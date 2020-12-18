import java.util.HashMap;
import java.util.Map;

public class SurnameFactory {
    private static Map<String, Surname> surnameMap = new HashMap<>();

    public static Surname getSurname(String surname) {
        Surname result = surnameMap.get(surname);

        if(result == null) {
            result = new Surname(surname);
            surnameMap.put(surname, result);
        }
        return result;
    }
}
