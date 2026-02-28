package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;


public class Calc {
    @SuppressWarnings("MagicNumber")
    // задался максимальным числом, чтобы было проще
    private static final int MAX_NUMBER = 100;
    private static final Random RANDOM = new Random();
    private static final int ROUNDS = 3;

    public static void calcGame() {
        Engine engine = new Engine("What is the result of the expression?");
        // задался максимальным числом, чтобы было проще
        engine.greeting();

        String[][] gameData = gameFilling();
        engine.runGame(gameData);
    }

    public static String[][] gameFilling() {
        String[][] gameDataFull = new String[ROUNDS][2];
        String[] mathOper = {"+", "-", "*"};

        for (int i = 0; i < ROUNDS; i++) {
            int firstNumber = RANDOM.nextInt(MAX_NUMBER) + 1;
            int secondNumber = RANDOM.nextInt(MAX_NUMBER) + 1;
            int operationNumber = RANDOM.nextInt(2) + 1;

            String mathOperation = mathOper[operationNumber];
            String question = firstNumber + " " + mathOperation + " " + secondNumber;

            int result = calculation(firstNumber, secondNumber, mathOperation);
            String correctAnswer = String.valueOf(result); // для сравнения по значению в ссылке

            gameDataFull[i][0] = question;
            gameDataFull[i][1] = correctAnswer;
        }
        return gameDataFull;
    }

    public static int calculation(int one, int two, String operation) {
        return switch (operation) {
            case "+" -> one + two;
            case "-" -> one - two;
            case "*" -> one * two;
            default -> throw new RuntimeException("Unknown state");
        };
    }

}
