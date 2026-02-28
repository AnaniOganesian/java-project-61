package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Progression {
    @SuppressWarnings("MagicNumber")
    private static final Random RANDOM_NUMBER = new Random();
    // задался минимумом равным 5 по условию задачи
    private static final int MIN_PRG_LENGTH = 5;
    // задался максимумом равным 10 по условию задачи
    private static final int MAX_PRG_LENGTH = 10;


    public static void prgGame() {
        Engine engine = new Engine( "What number is missing in the progression?");
        engine.greeting();

        //Random random = new Random(); убрано по результатам checkstyle
        int noOfCorrectAnswers = 0;
        // выбираем случайное число в зависимости от длины массива
        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int progressionLength = RANDOM_NUMBER.nextInt(MAX_PRG_LENGTH - MIN_PRG_LENGTH + 1)
                    + MIN_PRG_LENGTH;
            int hiddenNumber = RANDOM_NUMBER.nextInt(progressionLength - 1) + 1;

            int[] arrays = progressionMaker(progressionLength);
            String[] stringArray = new String[arrays.length];
            // заполняю массив стрингов из массива чисел, чтобы при выводе заменить строку двумя точками
            for (int i = 0; i < arrays.length; i++) {
                stringArray[i] = String.valueOf(arrays[i]);
            }
            String question = String.join(" ", Arrays.copyOfRange(stringArray, 0, hiddenNumber))
                + " .. "
                + String.join(" ", Arrays.copyOfRange(stringArray, hiddenNumber + 1, stringArray.length));

            int correctAnswer = arrays[hiddenNumber];

            if (engine.getQuestions(question, String.valueOf(correctAnswer))) {
                noOfCorrectAnswers++;
            } else {
                return;
            }
        }
        System.out.println("Congratulations, " + engine.getPlayerName() + "!");

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
