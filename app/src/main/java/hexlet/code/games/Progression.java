package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Progression {
    static Random random = new Random();
    private static int minPrgLength = 5;
    private static int maxPrgLength = 10;


    public static void prgGame(Scanner scanner) {
        Engine engine = new Engine(scanner, "What number is missing in the progression?");
        engine.greeting();

        //Random random = new Random(); убрано по результатам checkstyle
        int noOfCorrectAnswers = 0;
        // выбираем случайное число в зависимости от длины массива
        while (noOfCorrectAnswers < engine.getNoOfRounds()) {
            int progressionLength = random.nextInt(maxPrgLength - minPrgLength + 1)
                    + minPrgLength;
            int hiddenNumber = random.nextInt(progressionLength - random.nextInt(4) + 1);

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
        //Random random = new Random(); убрано по результатам checkstyle

        int difference = random.nextInt(5) + 2; // число для создания прогрессии
        int[] arrays = new int[progressionLength];
        arrays[0] = random.nextInt(10); // принял условие, что числа в прогрессии с 0 до 10;
        for (int i = 1; i < arrays.length; i++) {
            arrays[i] = arrays[i - 1] + difference;
        }
        return arrays;
    }

}
