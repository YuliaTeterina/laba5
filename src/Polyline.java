import java.util.List;
import java.util.stream.Collectors;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("Список точек не может быть null");
        }
        this.points = points;
    }

    @Override
    public String toString() {
        return "Линия " + points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }
}