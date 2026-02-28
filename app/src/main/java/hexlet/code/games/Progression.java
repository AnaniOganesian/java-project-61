package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Arrays;
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
            int progressionLength = RANDOM_NUMBER.nextInt(MAX_PRG_LENGTH - MIN_PRG_LENGTH + 1)
                    + MIN_PRG_LENGTH;
            int hiddenNumber = RANDOM_NUMBER.nextInt(progressionLength - 1) + 1;

            int[] arrays = progressionMaker(progressionLength);
            String[] stringArray = new String[arrays.length];
            // заполняю массив стрингов из массива чисел, чтобы при выводе заменить строку двумя точками

            for (int j = 0; j < arrays.length; j++) {
                stringArray[j] = String.valueOf(arrays[j]);
            }

            String question = String.join(" ", Arrays.copyOfRange(stringArray, 0, hiddenNumber))
                    + " .. "
                    + String.join(" ", Arrays.copyOfRange(stringArray, hiddenNumber + 1, stringArray.length));

            int correctAnswer = arrays[hiddenNumber];

            dataGameFill[i][0] = question;
            dataGameFill[i][1] = String.valueOf(correctAnswer);
        }

        return dataGameFill;

    }
    //
    public static int[] progressionMaker(int progressionLength) {

        int difference = RANDOM_NUMBER.nextInt(MIN_PRG_LENGTH) + 2;
        int[] arrays = new int[progressionLength];
        arrays[0] = RANDOM_NUMBER.nextInt(MAX_PRG_LENGTH); // принял условие, что числа в прогрессии с 0 до 10;
        for (int i = 1; i < arrays.length; i++) {
            arrays[i] = arrays[i - 1] + difference;
        }
        return arrays;
    }

}
