package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;



public class Even {
    // задался максимальным числом, чтобы было проще
    @SuppressWarnings("MagicNumber")
    private static final int MAX_NUMBER = 100;

    public static void evenGame(Scanner scanner) {
        // int noOfRounds = 3;
        Engine engine = new Engine(scanner, "Answer 'yes' if the number is even, otherwise answer 'no'.");


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


        /*        int maxNumber = 100;
       //Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        // Ввод имени
        String name = scanner.nextLine().trim();
        System.out.println("Hello, " + name + "!");


        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        int correctAnswers = 0;

        while (correctAnswers < noOfRounds) {
            int number = random.nextInt(maxNumber) + 1;  //
            String correctAnswer = isEven(number) ? "yes" : "no";

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " + "Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");

         */
