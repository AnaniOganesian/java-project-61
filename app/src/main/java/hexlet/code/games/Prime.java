package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    // задался максимальным числом, чтобы было проще
    @SuppressWarnings("MagicNumber")
    private static final int MAX_NUMBER = 100;
    private static final int ROUNDS = 3;
    private static final Random RANDOM = new Random();

    public static void primeGame() {
        Engine engine = new Engine("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        engine.greeting();

        String[][] gameData = gameFilling();
        engine.runGame(gameData);
    }

    public static String[][] gameFilling() {
        String[][] gameDataFull = new String[ROUNDS][2];

        for (var i = 0; i < ROUNDS; i++) {
            int number = RANDOM.nextInt(MAX_NUMBER);

            String question = String.valueOf(number);
            String correctAnswer = isPrime(number) ? "yes" : "no";

            gameDataFull[i][0] = question;
            gameDataFull[i][1] = correctAnswer;

        }
        return gameDataFull;

    }

    public static boolean isPrime(int number) {

        if (number == 2) {
            return true;
        }

        if (number < 2) {
            return false;
        }

        if (number % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);

        final int PRIME_MIN_NUMBER = 3;

        for (int i = PRIME_MIN_NUMBER ; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }

}
