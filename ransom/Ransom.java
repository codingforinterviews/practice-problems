import java.util.HashMap;
import java.util.Map;

public class Ransom {
    public static boolean canRansom(String magazine, String ransom) {
        if (magazine.length() < ransom.length()) {
            return false;
        }
        Map<String, Integer> magMap = new HashMap<>();
        for (String word : magazine.split(" ")) {
            if (magMap.containsKey(word)) {
                magMap.put(word, magMap.get(word) + 1);
            } else {
                magMap.put(word, 1);
            }
        }

        for (String word : ransom.split(" ")) {
            if (!magMap.containsKey(word)) {
                return false;
            }
            if (magMap.get(word) == 1) {
                magMap.remove(word);
            } else {
                magMap.put(word, magMap.get(word) - 1);
            }
        }
        return true;
    }
}
