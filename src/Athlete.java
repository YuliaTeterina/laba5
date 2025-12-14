import java.util.List;

public class Athlete {
    private String lastName;
    private String firstName;
    private int totalScore;

    public Athlete(String lastName, String firstName, List<Integer> scores) {
        this.lastName = lastName;
        this.firstName = firstName;

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        this.totalScore = sum;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + totalScore;
    }
}