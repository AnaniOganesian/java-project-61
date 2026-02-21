package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Prime {
    // задался максимальным числом, чтобы было проще
    @SuppressWarnings("MagicNumber")
    private static final int MAX_NUMBER = 100;
    private static final int PRIME_CHECK_MIN_NUMBER = 3;
    public static void primeGame(Scanner scanner) {
        Engine engine = new Engine(scanner, "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        engine.greeting();

        Random random = new Random();

        int noOfCorrectAnswers = 0;

        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int number = random.nextInt(MAX_NUMBER);

            String question = String.valueOf(number);
            String correctAnswer = isPrime(number) ? "yes" : "no";

            if (engine.getQuestions(question, correctAnswer)) {
                noOfCorrectAnswers++;
            } else {
                return;
            }

        }
        System.out.println("Congratulations, " + engine.getPlayerName() + "!");


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

        for (int i = PRIME_CHECK_MIN_NUMBER; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }

}
