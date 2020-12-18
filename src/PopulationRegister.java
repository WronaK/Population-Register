import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PopulationRegister implements IterableCollection {
    private Map<String, Name> populationRegister = new HashMap<>();

    public void add(String name, String[] surname, String pesel) {
        Name objectName = NameFactory.getName(name, surname, pesel);
        populationRegister.put(name, objectName);
    }

    public void tree() {
        for(Iterator iteratorName = createIterator(); iteratorName.hasNext();) {
            Name objectName = (Name) iteratorName.next();
            System.out.println(objectName);
            for(Iterator iteratorMemberOfSurnames = objectName.createIterator(); iteratorMemberOfSurnames.hasNext();) {
                MemberOfSurnames memberOfSurnames = (MemberOfSurnames) iteratorMemberOfSurnames.next();
                System.out.println("\t" + memberOfSurnames);
                for(Iterator iteratorPesel = memberOfSurnames.createIterator(); iteratorPesel.hasNext();) {
                    Pesel pesel = (Pesel) iteratorPesel.next();
                    System.out.println("\t\t"+ pesel);
                }
            }
        }
    }

    public void displayBranchForName(String name) {
        Name person = populationRegister.get(name);
        if(person != null) {
            System.out.println(person);
            for (Iterator iteratorMemberOfSurnames = person.createIterator(); iteratorMemberOfSurnames.hasNext(); ) {
                MemberOfSurnames memberOfSurnames = (MemberOfSurnames) iteratorMemberOfSurnames.next();
                System.out.println("\t" + memberOfSurnames);
                for (Iterator iteratorPesel = memberOfSurnames.createIterator(); iteratorPesel.hasNext(); ) {
                    Pesel pesel = (Pesel) iteratorPesel.next();
                    System.out.println("\t\t" + pesel);
                }
            }
        } else {
            System.out.println("Nie ma takiej gałęźi w drzewie");
        }
    }

    public void displayBranchForSurname(String name, String[] surname) {
        Name person = populationRegister.get(name);
        if(person != null) {
            for (Iterator iteratorMemberOfSurnames = person.createIterator(); iteratorMemberOfSurnames.hasNext(); ) {
                MemberOfSurnames memberOfSurnames = (MemberOfSurnames) iteratorMemberOfSurnames.next();
                if(memberOfSurnames.checkExistMemeber(surname)) {
                    System.out.println(person + " " + memberOfSurnames);
                    for (Iterator iteratorPesel = memberOfSurnames.createIterator(); iteratorPesel.hasNext(); ) {
                        Pesel pesel = (Pesel) iteratorPesel.next();
                        System.out.println("\t\t" + pesel);
                    }
                }
            }
        } else {
            System.out.println("Nie ma takiej gałęźi w drzewie");
        }
    }

    public boolean isExist(String name, String[] surname, String pesel) {
        Name objectName = populationRegister.get(name);
        if(objectName != null) {
            for (Iterator iteratorMemberOfSurnames = objectName.createIterator(); iteratorMemberOfSurnames.hasNext(); ) {
                MemberOfSurnames objectMemberOfSurnames = (MemberOfSurnames) iteratorMemberOfSurnames.next();
                if(objectMemberOfSurnames.checkExistMemeber(surname)) {
                    for (Iterator iteratorPesel = objectMemberOfSurnames.createIterator(); iteratorPesel.hasNext(); ) {
                        Pesel objectPesel = (Pesel) iteratorPesel.next();
                        if(objectPesel.getPesel().equals(pesel)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void remove(String name, String[] surname, String pesel) {
        Name objectName = populationRegister.get(name);
        if(objectName != null) {
            MemberOfSurnames member = null;
            for(Iterator iteratorMemberOfSurnames = objectName.createIterator(); iteratorMemberOfSurnames.hasNext();) {
                MemberOfSurnames memberOfSurnames = (MemberOfSurnames) iteratorMemberOfSurnames.next();
                if(memberOfSurnames.checkExistMemeber(surname)) {
                    member = memberOfSurnames;
                }
            }
            if(member != null) {
                member.removePesel(pesel);
                objectName.removeMemeberOfSurnames(surname);

                if (objectName.getNumberOfMembersOfSurnames() == 0) {
                    populationRegister.remove(name, objectName);
                }
            }
        }
    }

    @Override
    public Iterator createIterator() {
        return populationRegister.values().iterator();
    }
}
