package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static void calcGame(Scanner scanner) {
        Engine engine = new Engine(scanner, "What is the result of the expression?");
        // задался максимальным числом, чтобы было проще
        @SuppressWarnings("MagicNumber")
        int maxNumber = 100;
        engine.greeting();
        Random random = new Random();

        String[] mathoper = {"+", "-", "*"};
        int noOfCorrectAnswers = 0;
// В цикле каждый раз выбираем новые числа и операцию, которую нужно произвести
        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int firstNumber = random.nextInt(maxNumber) + 1;
            int secondNumber = random.nextInt(maxNumber) + 1;
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
