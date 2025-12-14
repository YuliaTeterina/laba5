import java.util.Random;

public class Funs {
    public static void meowsCare(Meowable meowable) {
        if (meowable == null) return;

        Random random = new Random();
        int meows = random.nextInt(10) + 1;

        for (int i = 0; i < meows; i++) {
            meowable.meow();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Мяуканье прервано!");
                return;
            }
        }
    }
}