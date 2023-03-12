// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TaskTwo {

    private static void BubbleSort(int[] numbers, Logger logger){

        int temp = 0;
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    count++;
                    String stringCounter = Integer.toString(count);
                    String arr = Arrays.toString(numbers);
                    logger.info("(" + stringCounter + ")" + " Iteration " + arr 
                    + " change from (" + numbers[j] + ") to (" + numbers[j + 1] + ")");
                }
            }
        }

    }
    public static void main (String[] args) throws SecurityException, IOException {

        Logger logger = Logger.getLogger(TaskTwo.class.getName());
        SimpleFormatter sf = new SimpleFormatter();
        FileHandler fh = new FileHandler("LogTaskTwo.txt");
        fh.setFormatter(sf);
        logger.addHandler(fh);
        int [] array = {1, 3, 6, 8, 2, 9, 8, 8, 2, 1};

        BubbleSort(array, logger);

    }
}