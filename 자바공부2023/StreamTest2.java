package 자바공부2023;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 중간 연산자
public class StreamTest2 {
    public static void main(String[] args) {
        // distinct : 중복제거
        IntStream ist = IntStream.of(1,2,2,3,3,3,4,5,5,6);
        ist.distinct().forEach(System.out::print);
        System.out.println();

        // filter : 조건식
        IntStream ist1 = IntStream.rangeClosed(1, 10);
        ist1.filter(i->i%2==0).forEach(System.out::print);
        // ist1.filter(i->i%2!=0 && i%3!=0).forEach(System.out::println);
        // ist1.filter(i->i%2!=0).filter(i->i%3!=0).forEach(System.out::println);
        System.out.println();

        // sorted : 정렬
        Stream<String> str = Stream.of(new String[] {"c", "b", "a", "e"});
        str.sorted().forEach(System.out::print);
        // str.sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println); //람다식 가능
        // str.sorted(String::compareTo).forEach(System.out::println); //위와 문장과 동일

        // 길이 순 정렬
        Stream<String> str1 = Stream.of(new String[] {"cc", "bbb", "a", "ee"});
        str1.sorted(Comparator.comparing(String::length)).forEach(System.out::print);
        // str1.sorted(Comparator.comparingInt(String::length)).forEach(System.out::print); // no오토박싱

        // 역순 정렬
        Stream<String> str2 = Stream.of(new String[] {"c", "b", "a", "e"});
        str2.sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // 대소문자 구분안함
        Stream<String> str3 = Stream.of(new String[] {"c", "b", "a", "e"});
        str3.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);
        str3.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::println); // 역순
        System.out.println();


    }
}
