import java.util.*;

public class Competition {
    public static List<String> processCompetition(List<String> inputLines) {
        int n = Integer.parseInt(inputLines.get(0));
        int m = Integer.parseInt(inputLines.get(1));

        List<Athlete> athletes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = inputLines.get(i + 2);
            String[] parts = line.split(" ");

            String lastName = parts[0];
            String firstName = parts[1];
            List<Integer> scores = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                scores.add(Integer.parseInt(parts[2 + j]));
            }

            athletes.add(new Athlete(lastName, firstName, scores));
        }

        athletes.sort((a1, a2) -> a2.getTotalScore() - a1.getTotalScore());

        List<String> result = new ArrayList<>();
        int place = 0;
        int prevScore = -1;

        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            int currentScore = athlete.getTotalScore();

            if (currentScore != prevScore) {
                place = place + 1;
            }

            result.add(athlete + " " + place);
            prevScore = currentScore;
        }

        return result;
    }
}