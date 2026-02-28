package hexlet.code.games;

import hexlet.code.Engine;
// import java.util.Arrays;
import java.util.Random;

public class Progression {
    @SuppressWarnings("MagicNumber")
    private static final Random RANDOM_NUMBER = new Random();
    // задался минимумом равным 5 по условию задачи
    private static final int MIN_PRG_LENGTH = 5;
    // задался максимумом равным 10 по условию задачи
    private static final int MAX_PRG_LENGTH = 10;
    private static final int ROUNDS = 3;


    public static void prgGame() {
        Engine engine = new Engine("What number is missing in the progression?");
        engine.greeting();
        String[][] gameData = gspGameFilling();
        engine.runGame(gameData);
    }

    public static String[][] gspGameFilling() {
        String[][] dataGameFill = new String[ROUNDS][2];

        for (int i = 0; i < ROUNDS; i++) {
            int length = RANDOM_NUMBER.nextInt(MAX_PRG_LENGTH - MIN_PRG_LENGTH + 1)
                    + MIN_PRG_LENGTH;
            int hiddenIndex = RANDOM_NUMBER.nextInt(length - 1) + 1;
            int step = RANDOM_NUMBER.nextInt(MIN_PRG_LENGTH) + 2;
            int firstNumber = RANDOM_NUMBER.nextInt(100);

            String[] progression = makeProgression(firstNumber, step, length);
            String correctAnswer = progression[hiddenIndex];

            progression[hiddenIndex] = "..";
            String question = String.join(" ", progression);

            dataGameFill[i][0] = question;
            dataGameFill[i][1] = String.valueOf(correctAnswer);
        }

        return dataGameFill;

    }
    //
    public static String[] makeProgression(int firstNumber, int step, int length) {
        String[] progression = new String[length];
        progression[0] = String.valueOf(firstNumber);
        int temp = firstNumber;
        for (int i = 1; i < length; i++) {
            temp += step;
            progression[i] = String.valueOf(temp);
        }

        return progression;

    }

}
