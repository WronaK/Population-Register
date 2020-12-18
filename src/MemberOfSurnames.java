import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemberOfSurnames implements IterableCollection {
    private List<Surname> memberOfSurname;
    private List<Pesel> pesel = new ArrayList<>();

    public MemberOfSurnames(List<Surname> surnames) {
        memberOfSurname = surnames;
    }

    public void addPesel(String pesel) {
        Pesel newPesel = PeselFactory.getNewPesel(pesel);
        if(newPesel != null) {
            this.pesel.add(newPesel);
        }
    }

    public boolean checkExistMemeber(List<Surname> s) {
        if(memberOfSurname.equals(s))  {
            return true;
        }
        return false;
    }

    public boolean checkExistMemeber(String[] s) {
        if(s.length != memberOfSurname.size()) {
            return false;
        } else {
            int i = 0;
            for(Surname member: memberOfSurname) {
                if(!(member.getSurname().equals(s[i]))) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    private String writeSegmentOfSurnames() {
        StringBuilder memberOfSurnames = new StringBuilder();
        for(Surname surname: memberOfSurname) {
            memberOfSurnames.append(surname.getSurname() + " ");
        }
        return memberOfSurnames.toString();
    }

    public void removePesel(String numberPesel) {
        Pesel objectPesel = null;
        for(Pesel p: pesel) {
            if(p.getPesel().equals(numberPesel)) {
                objectPesel = p;
            }
        }
        if(objectPesel != null) {
            pesel.remove(objectPesel);
            PeselFactory.removePesel(numberPesel);
        }
    }

    public int getNumberOfPesels() {
        return pesel.size();
    }

    @Override
    public String toString() {
        return writeSegmentOfSurnames();
    }

    @Override
    public Iterator createIterator() {
        return pesel.iterator();
    }
}
