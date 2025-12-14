import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = InputValidator.getIntInRange("Выберите задание (1-7, 0 - выход): ", 0, 7);

            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("Выход из программы...");
                    break;
                case 1:
                    runTask1();
                    break;
                case 2:
                    runTask2();
                    break;
                case 3:
                    runTask3();
                    break;
                case 4:
                    runTask4();
                    break;
                case 5:
                    runTask5();
                    break;
                case 6:
                    runTask6();
                    break;
                case 7:
                    runTask7();
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }

            if (running && choice != 0) {
                System.out.println("\nНажмите Enter для продолжения...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== МЕНЮ ===");
        System.out.println("1. Дроби с кэшированием");
        System.out.println("2. Кот и мяуканье");
        System.out.println("3. Первые вхождения в списке");
        System.out.println("4. Соревнования по многоборью");
        System.out.println("5. Символы из четных слов");
        System.out.println("6. Очередь в обратном порядке");
        System.out.println("7. Точки и стримы");
        System.out.println("0. Выход");
    }

    private static void runTask1() {
        System.out.println("\n=== Задание 1.1: Шаблоны (Дроби) ===");

        System.out.print("Введите числитель: ");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите знаменатель: ");
        int den = Integer.parseInt(scanner.nextLine());

        try {
            CachedFraction cf = new CachedFraction(num, den);

            System.out.println("\nКэшированная дробь " + cf + ":");
            double v1 = cf.getRealValue();
            double v2 = cf.getRealValue();
            System.out.println("Первое значение (вычислено): " + v1);
            System.out.println("Второе значение (взято из кэша): " + v2);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void runTask2() {
        System.out.println("\n=== Задание 2.1:  Структурные шаблоны (Количество мяуканий) ===");

        System.out.print("Введите имя кота: ");
        String name = scanner.nextLine();

        try {
            Cat cat = new Cat(name);
            System.out.println("Создан: " + cat);
            System.out.println("Запускаем мяуканье...");

            Funs.meowsCare(cat);
            System.out.println("Кот мяукал " + cat.getMeowCount() + " раз");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void runTask3() {
        System.out.println("\n=== Задание 3.10: Список (Первые вхождения) ===");

        System.out.println("Введите элементы через пробел:");
        String input = scanner.nextLine();

        List<String> list = Arrays.asList(input.split("\\s+"));

        System.out.println("Исходный список: " + list);
        List<String> result = ListProcessor.keepFirstOccurrences(list);
        System.out.println("После удаления повторов: " + result);
    }

    private static void runTask4() {
        System.out.println("\n=== Задание 4.10: Мап (Многоборье) ===");

        try {

            List<String> lines = Files.readAllLines(Paths.get("competition.txt"));
            List<String> results = Competition.processCompetition(lines);

            System.out.println("Результаты:");
            for (String r : results) {
                System.out.println(r);
            }

        } catch (Exception e) {
            System.out.println("Ошибка: создайте файл competition.txt");
        }
    }

    private static void runTask5() {
        System.out.println("\n=== Задание 5.6: Сет (Символы из четных слов) ===");

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        Set<Character> chars = TextAnalyzer.getCharsFromEvenWords(text);
        System.out.println("Символы из слов с четными номерами:");
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static void runTask6() {
        System.out.println("\n=== Задание 6.1: Очередь (Очередь в обратном порядке) ===");

        Queue<String> queue = new LinkedList<>();
        System.out.println("Введите элементы очереди через пробел:");
        String input = scanner.nextLine();

        for (String s : input.split(" ")) {
            queue.add(s);
        }

        System.out.println("Очередь: " + queue);
        QueueReverser.printQueueReversed(queue);
    }

    private static void runTask7() {
        System.out.println("\n=== Задание 7: Стрим ===");
        System.out.println("1. Обработка точек");
        System.out.println("2. Обработка файла с именами");
        System.out.print("Выберите: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            List<Point> points = new ArrayList<>();
            System.out.println("Введите точки в формате 'x y' (пустая строка - завершить):");

            while (true) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) break;

                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    try {
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        points.add(new Point(x, y));
                    } catch (Exception e) {
                        System.out.println("Некорректный ввод, пропускаем...");
                    }
                }
            }

            Polyline polyline = StreamProcessor.processPoints(points);
            System.out.println("Ломаная линия: " + polyline);

        } else if (choice == 2) {
            String filename = "people.txt";

            try {
                Map<Integer, List<String>> result = StreamProcessor.processPeopleFile(filename);
                System.out.println("Результат:");
                for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}