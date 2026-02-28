package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Calc {
    @SuppressWarnings("MagicNumber")
    // задался максимальным числом, чтобы было проще
    private static final int MAX_NUMBER = 100;

    public static void calcGame() {
        Engine engine = new Engine( "What is the result of the expression?");
        // задался максимальным числом, чтобы было проще


        engine.greeting();
        Random random = new Random();

        String[] mathoper = {"+", "-", "*"};
        int noOfCorrectAnswers = 0;
// В цикле каждый раз выбираем новые числа и операцию, которую нужно произвести
        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int firstNumber = random.nextInt(MAX_NUMBER) + 1;
            int secondNumber = random.nextInt(MAX_NUMBER) + 1;
            int operationNumber = random.nextInt(2) + 1;

            String mathOperation = mathoper[operationNumber];
            String question = firstNumber + " " + mathOperation + " " + secondNumber;

            int result = calculation(firstNumber, secondNumber, mathOperation);
            String correctAnswer = String.valueOf(result); // для сравнения по значению в ссылке

            if (engine.getQuestions(question, correctAnswer)) {
                noOfCorrectAnswers++;
            } else {
                return;
            }

        }
        System.out.println("Congratulations, " + engine.getPlayerName() + "!");
    }
    public static int calculation(int one, int two, String operation) {
        return switch (operation) {
            case "+" -> one + two;
            case "-" -> one - two;
            case "*" -> one * two;
            default -> 0;
        };
    }
}
