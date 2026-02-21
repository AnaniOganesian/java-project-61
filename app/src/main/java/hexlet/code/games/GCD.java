package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class GCD {

    public static void nodGame(Scanner scanner) {
        Engine engine = new Engine(scanner, "Find the greatest common divisor of given numbers.");
        engine.greeting();
        int maxNumber = 100;
        Random random = new Random();

        int noOfCorrectAnswers = 0;
        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int firstNumber = random.nextInt(maxNumber);
            int secondNumber = random.nextInt(maxNumber);

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
