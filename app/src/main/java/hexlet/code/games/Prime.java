package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Prime {

    public static void primeGame(Scanner scanner){
        Engine engine = new Engine(scanner, "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        engine.greeting();

        Random random = new Random();

        int noOfCorrectAnswers = 0;

        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int number = random.nextInt(100);

            String question = String.valueOf(number);
            String correctAnswer = isPrime(number) ? "yes" : "no";

            if (engine.getQuestions(question, correctAnswer)) {
                noOfCorrectAnswers++;
            }
            else {
                return;
            }

        }
        System.out.println("Congratulations, " + engine.getPlayerName() + "!");


    }

    public static boolean isPrime(int number){

        if (number == 2) {
            return true;
        }

        if (number < 2) {
            return false;
        }

        if (number % 2 == 0){
            return false;
        }

        int sqrt = (int) Math.sqrt(number);

        for (int i = 3; i < sqrt; i+=2){
            if (number % i == 0){
                return false;
            }
        }
        return true;

    }

}
