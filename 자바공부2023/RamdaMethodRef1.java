package 자바공부2023;

import java.util.function.Function;
import java.util.function.Supplier;

public class RamdaMethodRef1 {
    public static void main(String[] args) {
        // 1) 타입
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s); // 람다식
        Function<String, Integer> f2 = Integer::parseInt; // 메서드 참조
        System.out.println(f1.apply("100") + f2.apply("200"));

        // 2) 객체
        // 생성자 없을 시 사용 법 (Supplier는 입력 X, 출력 O (공급자))
        Supplier<MyClass> s1 = () -> new MyClass(); // 람다식
        Supplier<MyClass> s2 = MyClass::new; // 메서드 참조
        System.out.println("\n" + s1.get() + " " + s2.get());
        // 생성자 있을 시 사용 법
        Function<Integer, MyClass> s3 = (i) -> new MyClass(); // 람다식
        System.out.println(s3.apply(100));
        Function<Integer, MyClass> s4 = MyClass::new; // 메서드 참조
        MyClass mc = s4.apply(200);
        System.out.println(mc.iv);
        System.out.println(s4.apply(150).iv); // 위 두줄을 한줄로

        // 3) 배열
        Function<Integer, int[]> a1 = (i) -> new int[i]; // 람다식
        System.out.println("\n" + a1.apply(10).length);
        Function<Integer, int[]> a2 = int[]::new; // 메서드 참조
        System.out.println(a2.apply(20).length);
    }
}

class MyClass {
    int iv;

    MyClass() {
        this.iv = 1;
    }
    MyClass(int iv) {
        this.iv = iv;
    }
}
