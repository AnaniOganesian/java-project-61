package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;



public class Even {
    // задался максимальным числом, чтобы было проще
    @SuppressWarnings("MagicNumber")
    private static final int MAX_NUMBER = 100;

    public static void evenGame() {
        // int noOfRounds = 3;
        Engine engine = new Engine("Answer 'yes' if the number is even, otherwise answer 'no'.");


        engine.greeting();
        Random random = new Random();
        int noOfCorrectAnswers = 0;

        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int number = random.nextInt(MAX_NUMBER) + 1;  //
            String correctAnswer = isEven(number) ? "yes" : "no";

            if (engine.getQuestions(String.valueOf(number), correctAnswer)) {
                noOfCorrectAnswers++;
            } else {
                return;
            }

        }
        System.out.println("Congratulations, " + engine.getPlayerName() + "!");
    }

    public static boolean isEven(int number) {  //
        return number % 2 == 0;
    }
}

