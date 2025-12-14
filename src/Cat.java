public class Cat implements Meowable {
    private String name;
    private int meowCount = 0;

    public Cat(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    @Override
    public void meow() {
        meowCount++;
        System.out.println(name + ": мяу");
    }

    public int getMeowCount() {
        return meowCount;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}