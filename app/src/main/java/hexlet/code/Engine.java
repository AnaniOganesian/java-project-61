package hexlet.code;

import java.util.Scanner;

public final class Engine {
    @SuppressWarnings("MagicNumber")
    private static int noOfRounds = 3;
    private Scanner scanner;
    private String playerName;
    private String gameDescription;
    //private int noOfCorrectAnswers = 0;

    public Engine(Scanner sc, String description) {
        this.scanner = sc;
        this.gameDescription = description;

    }
    public int getNoOfRounds() {
        return noOfRounds;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void greeting() {
        //System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        // Ввод имени
        this.playerName = scanner.nextLine().trim();

        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameDescription);

    }
// Задаем основную логику игры. Задается вопрос, принимается ответ. Если ответ правильный, то увеличиваем
// счечик. Если нет, то заканчиваем игру.
    public boolean getQuestions(String question, String answer) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().trim().toLowerCase();

        if (userAnswer.equals(answer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. " + "Correct answer was '"
                    + answer + "'.");
            System.out.println("Let's try again, " + playerName + "!");
            return false;
        }


    }
}

