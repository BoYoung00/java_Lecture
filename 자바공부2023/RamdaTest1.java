package 자바공부2023;

public class RamdaTest1 {
    public static void main(String[] args) {
        //람다식을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다
        MyFunction1 f = new MyFunction1() {
            public int max(int a, int b) { // 오버라이딩 - 접근제어자느 좁게 못 바꿈
                return a > b ? a : b;
            }
        };
        int val = f.max(3, 5);
        System.out.println(val);

        // 더 짧게 쓰는 법
        MyFunction1 f2 = (a, b) -> a > b ? a : b;
        int val2 = f2.max(3, 5);
        System.out.println(val2);
    }
}

@FunctionalInterface //함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
interface MyFunction1 {
    public abstract int max(int a, int b);
}
