package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {
    // задался максимальным числом, чтобы было проще
    @SuppressWarnings("MagicNumber")
    private static final int MAX_NUMBER = 100;
    private static final int ROUNDS = 3;
    private static final Random RANDOM = new Random();

    public static void evenGame() {

        Engine engine = new Engine("Answer 'yes' if the number is even, otherwise answer 'no'.");
        engine.greeting();

        String[][] gameData = gameFilling();
        engine.runGame(gameData);

    }

    public static String[][] gameFilling() {
        String[][] gameDataFull = new String[ROUNDS][2];
        for (int i = 0; i < ROUNDS; i++) {
            int number = RANDOM.nextInt(MAX_NUMBER) + 1;  //
            String question = String.valueOf(number);
            String correctAnswer = isEven(number) ? "yes" : "no";
            gameDataFull[i][0] = question;
            gameDataFull[i][1] = correctAnswer;

        }
        return gameDataFull;
    }

    public static boolean isEven(int number) {  //
        return number % 2 == 0;
    }
}
