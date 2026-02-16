package hexlet.code;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner; // испортировали сканнер для ввода текста


public class App {
    public static void main(String[] args) {
        // Просим выбрать игру (в т.ч. приветствие), выводим список игр или выходим
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        // Вводим выборку через класс Scanner
        Scanner scanner = new Scanner(System.in);


        System.out.print("Your choice: ");
        int choice = scanner.nextInt(); // ввод выбора
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Welcome to the Brain Games!");
                Cli.getName();
                break;
            case 2:
                System.out.println("Welcome to the Brain Games!");
                Even.evenGame(scanner);
                break;
            case 3:
                System.out.println("Welcome to the Brain Games!");
               // Calc.calcGame(scanner);
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Wrong number, Darling. Try again!");
        }

        scanner.close();
    }
}
