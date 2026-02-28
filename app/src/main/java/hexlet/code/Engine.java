package hexlet.code;

import java.util.Scanner;

public final class Engine {
    @SuppressWarnings("MagicNumber")
    private static final int NUMBER_OF_ROUNDS = 3;
    private final Scanner scanner = new Scanner(System.in);
    private String playerName;
    private final String gameDescription;
    //private int noOfCorrectAnswers = 0;

    public Engine(String description) {
        this.gameDescription = description;
    }
    public int getNoOfRounds() {
        return NUMBER_OF_ROUNDS;
    }
    public String getPlayerName() {
        return playerName;
    }
    // приветствие
    public void greeting() {
        //System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        // Ввод имени
        this.playerName = scanner.nextLine().trim();
        System.out.println("Hello, " + playerName + "!");
    }

// Корректировки по замечаниям. Игра ничего не выводит на экран. Движок заполняет двумерный массив

    public void runGame(String[][] games) {
        System.out.println(gameDescription);

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            String question = games[i][0];
            String correctAnswer = games[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " + "Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                return;
            }

        }

        System.out.println("Congratulations, " + playerName + "!");

    }





}
