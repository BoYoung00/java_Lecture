package 자바공부2023;

public class StringTest {
    public static void main(String[] args) {
        int i1 = "aaa".compareTo("aaa");
        int i2 = "aaa".compareTo("bbb");
        int i3 = "bbb".compareTo("aaa");

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

    }
}
