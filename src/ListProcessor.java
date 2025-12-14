import java.util.*;

public class ListProcessor {
    public static <T> List<T> keepFirstOccurrences(List<T> list) {
        if (list == null) return new ArrayList<>();

        List<T> result = new ArrayList<>();
        Set<T> seen = new HashSet<>();

        for (T item : list) {
            if (!seen.contains(item)) {
                seen.add(item);
                result.add(item);
            }
        }

        return result;
    }
}