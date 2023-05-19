package 자바공부2023;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*; //매개변수 2개인 함수형 if

// Supplier<T> : 매개변수 X / 반환 O / 호출 : get()
// Consumer<T, U> : 매개변수 2 / 반환 X / 호출 : accept(T t)
// Predicate<T, U> : 조건식(수학)을 표현하는데 사용, 매개변수 2 / boolean 반환 / 호출 : apply(T t)
// Function<T, U, R> : 매개변수 2 / 반환 1 / 호출 : test(T t)

// UnaryOperator<T> : Function의 자손, Function과 달리 매개변수의 결과의 타입이 같음 (단항 연산자)
// BinaryOperator<T> : BiFunction의 자손, BiFunction과 달리 매개변수와 결과의 타입이 같음 (이항 연산자)
public class FunctionPackageTest {
    public static void main(String[] args) {
        Supplier<Integer> s = ()->(int)(Math.random()*100)+1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i%2==0;
        Function<Integer, Integer> f = i -> i/10*10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list); // list에 랜덤값 추가
        System.out.println(list);
        printEvenNum(p, c, list); // 짝수 출력
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i))
                c.accept(i);
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get()); // Supplier로 부터 1~100의 난수를 받아서 list에 추가
        }
    }
}
