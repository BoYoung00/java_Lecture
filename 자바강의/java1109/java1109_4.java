package 자바강의.java1109;

public class java1109_4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        for (int x : arr)
            System.out.println("increment 메서드 호출");

        increment(arr);
        for (int x : arr)
            System.out.println(x);
    }
    public static void increment(int[] n) {
        for (int i = 0; i < n.length; i++)
            n[i] *= 10;
        return;
    }
}
