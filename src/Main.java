import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[][] result = ArrayGenerator.generateAndSortArrays(count);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}