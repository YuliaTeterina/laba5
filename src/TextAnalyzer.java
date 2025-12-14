import java.util.*;

public class TextAnalyzer {
    public static Set<Character> getCharsFromEvenWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new HashSet<>();
        }

        String[] words = text.split("\\s+");
        Set<Character> chars = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if ((i + 1) % 2 == 0) {
                for (char c : words[i].toCharArray()) {
                    chars.add(c);
                }
            }
        }

        return chars;
    }
}