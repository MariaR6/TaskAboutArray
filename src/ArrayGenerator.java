import java.util.*;

public class ArrayGenerator {

    public static final int MAX_ARRAY_SIZE = 100;

    public static int[][] generateAndSortArrays(int count) {
        if (count < 0) throw  new IllegalArgumentException("Число массивов не может быть отрицательным");
        int[][] result = new int[count][];
        List<Integer> lenghts = new ArrayList<>(generateUniqueNumbers(count));
        // HashSet хранит integer-ы отсортированными, поэтому перемешиваем
        Collections.shuffle(lenghts);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int lengthCurrentArray = lenghts.get(i);
            int[] array = result[i] = new int[lengthCurrentArray];

            for (int j = 0; j < lengthCurrentArray; j++) {
                array[j] = random.nextInt();
            }
            Arrays.sort(array);
            // Если порядковый номер считать с 1, то отсортированными по убыванию должны быть массивы с четными индексами
            if (i % 2 == 0) {
                reverse(array);
            }
        }
        return result;
    }


    private static Set<Integer> generateUniqueNumbers(int count) {
        // Если count будет достаточно близок к MAX_ARRAY_SIZE, то создание займет очень много времени
        if (count > MAX_ARRAY_SIZE / 2) throw new IllegalArgumentException("Невозможно создать так много чисел");
        Set<Integer> lengthSet = new HashSet<>();
        Random random = new Random();
        while (lengthSet.size() < count) {
            lengthSet.add(random.nextInt(MAX_ARRAY_SIZE));
        }
        return lengthSet;
    }

    public static void reverse(int[] array) {
        if (array.length == 0) {
            return;
        }
        int last = array.length - 1;
        int middle = array.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = array[i];
            array[i] = array[last - i];
            array[last - i] = temp;
        }
    }
}
