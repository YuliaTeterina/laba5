import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StreamProcessor {
    public static Polyline processPoints(List<Point> points) {
        return points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Point::getX))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Polyline::new
                ));
    }

    public static Map<Integer, List<String>> processPeopleFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .map(line -> line.split(":"))
                .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())
                .map(parts -> {
                    String name = parts[0].trim();
                    String numberStr = parts[1].trim();

                    if (!name.isEmpty()) {
                        name = name.substring(0, 1).toUpperCase() +
                                name.substring(1).toLowerCase();
                    }

                    return new AbstractMap.SimpleEntry<>(
                            Integer.parseInt(numberStr),
                            name
                    );
                })
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}