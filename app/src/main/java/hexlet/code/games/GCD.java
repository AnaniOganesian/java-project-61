package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class GCD {
    // задался максимальным числом, чтобы было проще
    @SuppressWarnings("MagicNumber")
    private static final int MAX_NUMBER = 100;

    public static void nodGame() {
        Engine engine = new Engine( "Find the greatest common divisor of given numbers.");
        engine.greeting();

        Random random = new Random();

        int noOfCorrectAnswers = 0;
        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int firstNumber = random.nextInt(MAX_NUMBER);
            int secondNumber = random.nextInt(MAX_NUMBER);

            String question = firstNumber + " " + secondNumber;
            int result = findNod(firstNumber, secondNumber);

            if (engine.getQuestions(question, String.valueOf(result))) {
                noOfCorrectAnswers++;
            } else {
                return;
            }

        }
        System.out.println("Congratulations, " + engine.getPlayerName() + "!");
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
