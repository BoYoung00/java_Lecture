package 자바공부2023;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2, 5};
        int[][] arr2D = {{11, 22}, {21, 22}};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr2D));

        String[][] str2D = {{"aaa", "bbb"},{"AAA", "BBB"}};
        String[][] str2D2 = {{"aaa", "bbb"},{"AAA", "BBB"}};

        System.out.println(Arrays.deepEquals(str2D, str2D2));

        int[] arr2 = Arrays.copyOf(arr, 7);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOfRange(arr, 2,4);
        System.out.println(Arrays.toString(arr3));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
