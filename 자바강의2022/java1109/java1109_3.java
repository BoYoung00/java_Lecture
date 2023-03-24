package 자바강의2022.java1109;

public class java1109_3 {
    public static void main(String[] args) {
        int x = 0;
        System.out.println("increment() 메서드 호출 전 : " + x);
        increment(x);
        System.out.println("increment() 메서드 호출 후 : " + x);
    }
    public static void increment(int n) {
        n++;
    }
}
