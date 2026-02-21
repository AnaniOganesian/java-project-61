package hexlet.code;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner; // испортировали сканнер для ввода текста


public class App {

    private static final String GREET = "1";
    private static final String EVEN = "2";
    private static final String CALC = "3";
    private static final String GCDGAME = "4";
    private static final String PROGRESSION = "5";
    private static final String PRIME = "6";
    private static final String EXIT = "0";
    public static void main(String[] args) {
        // Просим выбрать игру (в т.ч. приветствие), выводим список игр или выходим
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        // Вводим выборку через класс Scanner
        Scanner scanner = new Scanner(System.in);


        System.out.print("Your choice: ");
        String choice = scanner.nextLine(); // ввод выбора

        switch (choice) {
            case GREET:
                Cli.getName();
                break;
            case EVEN:
                Even.evenGame(scanner);
                break;
            case CALC:
                Calc.calcGame(scanner);
                break;
            case GCDGAME:
                GCD.nodGame(scanner);
                break;
            case PROGRESSION:
                Progression.prgGame(scanner);
                break;
            case PRIME:
                Prime.primeGame(scanner);
                break;
            case EXIT:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Wrong number, Darling. Try again!");
        }

        scanner.close();
    }
}
