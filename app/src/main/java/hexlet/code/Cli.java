package hexlet.code;
import java.util.Scanner; // испортировали сканнер для ввода текста
// согласно заданию

public class Cli {

    public static void getName() {
        // Создаем объект класса сканнер, который считывает введеный текст
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        // Ввод имени
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        scanner.close();

    }
}
