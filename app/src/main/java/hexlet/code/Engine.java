package hexlet.code;

import java.util.Scanner;

public final class Engine {
    @SuppressWarnings("MagicNumber")
    private static final int NUMBER_OF_ROUNDS = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    // private static String playerName;
    //private static String gameDescription;
    //private static String[][] games;

/*    public Engine(String description, String[][] gamesData) {
        this.gameDescription = description;
        this.games = gamesData;
    }


   public int getNoOfRounds() { return NUMBER_OF_ROUNDS; }

    public String getPlayerName() {
        return playerName;
    } */
    public static int getNumberOfRounds() {
        return NUMBER_OF_ROUNDS;
    }

    public static void runGame(String description, String[][] gamesData) {
        // Greeting
        System.out.print("May I have your name? ");
        String playerName = SCANNER.nextLine().trim();
        System.out.println("Hello, " + playerName + "!");
        // Game itself
        System.out.println(description);

        //for (int i = 0; i < NUMBER_OF_ROUNDS; i++)
        for (String[] game : gamesData) {
            String question = game[0];
            String correctAnswer = game[1];
            //String question = gamesData[i][0];
            // String correctAnswer = gamesData[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine().toLowerCase();

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
