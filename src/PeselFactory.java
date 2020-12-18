import java.util.HashMap;
import java.util.Map;

public class PeselFactory {
    private static Map<String, Pesel> peselMap = new HashMap<>();

    public static Pesel getNewPesel(String pesel) {
       Pesel result = peselMap.get(pesel);

        if(result == null) {
            result = new Pesel(pesel);
            peselMap.put(pesel, result);
            return result;
        }
        return null;
    }

    public static void removePesel(String pesel) {
        peselMap.remove(pesel);
    }
}
