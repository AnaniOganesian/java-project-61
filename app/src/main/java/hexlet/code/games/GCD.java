package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    // задался максимальным числом, чтобы было проще
    @SuppressWarnings("MagicNumber")
    private static final int MAX_NUMBER = 100;
    private static final int ROUNDS = 3;
    private static final Random RANDOM = new Random();

    public static void nodGame() {
        Engine engine = new Engine("Find the greatest common divisor of given numbers.");
        engine.greeting();

        String[][] gameData = gameFilling();
        engine.runGame(gameData);
    }

    public static String[][] gameFilling() {
        String[][] gameDataFull = new String[ROUNDS][2];
        for (int i = 0; i < ROUNDS; i++) {
            int firstNumber = RANDOM.nextInt(MAX_NUMBER);
            int secondNumber = RANDOM.nextInt(MAX_NUMBER);

            String question = firstNumber + " " + secondNumber;
            int correctAnswer = findNod(firstNumber, secondNumber);

            gameDataFull[i][0] = question;
            gameDataFull[i][1] = String.valueOf(correctAnswer);

        }
        return gameDataFull;
    }

    private static int findNod(int firstNumber, int secondNumber) {
        int a = firstNumber;
        int b = secondNumber;

        if (b == 0) {
            return a;
        }

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
}
