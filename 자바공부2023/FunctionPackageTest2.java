package 자바공부2023;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionPackageTest2 {
    public static void main(String[] args) {
        // andThen
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i); //2진수 변환

        Function<String, String> h = f.andThen(g); //f를 실행하고 그 결과값으로 g를 실행
        Function<Integer, Integer> h2 = f.compose(g); //g를 실행하고 그 결과값으로 f를 실행

        System.out.println(h.apply("FF"));
        System.out.println(h2.apply(2));

        // 항등 함수(identity function)
        Function<String, String > f2 = x -> x;
        System.out.println(f2.apply("AAA")); // AAA가 그대로 출력


        // 조건식 and, or, not
        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i%2 == 0;
        Predicate<Integer> notP = p.negate(); // p 결과값의 부정(!)
        Predicate<Integer> all = notP.and(q.or(r)); // and or
        System.out.println(all.test(150));


        // 비교 equals
        String str1 = new String("abc");
        String str2 = new String("abc");
        // boolean result = str1.equals(str2); 와 같음
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        System.out.println(result);

    }
}
