import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Name implements IterableCollection {
    private String name;
    private List<MemberOfSurnames> memberOfSurnames = new ArrayList<>();

    public Name(String name) {
        this.name = name;
    }

    public MemberOfSurnames addMemberOfSurnames(String[] surname) {
        List<Surname> surnames = addSurname(surname);
        MemberOfSurnames member = findMember(surnames);
        if(member == null) {
            member = new MemberOfSurnames(surnames);
            memberOfSurnames.add(member);
        }
        return member;
    }

    public void addPesel(String[] s, String pesel) {
        MemberOfSurnames mm = addMemberOfSurnames(s);
        mm.addPesel(pesel);
    }

    private List<Surname> addSurname(String[] surname) {
        List<Surname> memebers = new ArrayList<>();
        for(String s: surname) {
            Surname ss = SurnameFactory.getSurname(s);
            memebers.add(ss);
        }
        return memebers;
    }

    private MemberOfSurnames findMember(List<Surname> surnames) {
        if (!memberOfSurnames.isEmpty()) {
            for (MemberOfSurnames member : this.memberOfSurnames) {
                if (member.checkExistMemeber(surnames)) {
                    return member;
                }
            }
        }
        return null;
    }

    public void removeMemeberOfSurnames(String[] surnames) {
        MemberOfSurnames objectMember = null;
        for(MemberOfSurnames s: memberOfSurnames) {
            if(s.checkExistMemeber(surnames)) {
                objectMember = s;
            }
        }

        if(objectMember.getNumberOfPesels() == 0) {
            memberOfSurnames.remove(objectMember);
        }
    }

    public int getNumberOfMembersOfSurnames() {
        return memberOfSurnames.size();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Iterator createIterator() {
        return memberOfSurnames.iterator();
    }

}


