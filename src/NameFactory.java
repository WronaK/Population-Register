import java.util.*;

public class NameFactory {
    private static Map<String, Name> nameMap = new HashMap<>();

    public static Name getName(String name, String[] surname, String pesel) {
        Name result = nameMap.get(name);

        if(result == null) {
            result = new Name(name);
            nameMap.put(name, result);
        }
        result.addMemberOfSurnames(surname);
        result.addPesel(surname, pesel);

        return result;
    }

}
