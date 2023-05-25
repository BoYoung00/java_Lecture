package 자바공부2023;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream(); // list를 stream에 넣음
        intStream.forEach(System.out::print); // forEach() 최종연산

        // stream은 1회용. 최종연산을 수행하면 닫힌다. (재사용시 다시 stream 생성)
        intStream = list.stream();
        intStream.forEach(System.out::println);

        // 문자배열 스트림
        Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});
//        strStream.forEach(System.out::println);
        System.out.println("문자 배열 개수="+strStream.count());

        // 숫자배열 스트림
        int[] intArr = {1,2,3,4,5};
        IntStream intStr = Arrays.stream(intArr);
//        System.out.println("count="+intStr.count()); // 최종연산
//        System.out.println("sum="+intStr.sum()); // 최종연산
        System.out.println("average="+intStr.average()); // 최종연산
        
        // 랜덤 스트림 (무한 난수 스트림)
        IntStream intRanStr = new Random().ints(); // 무한 스트림 / ints(5) 5개 반환 / ints(5, 10) 5~10 사이만 반환 / ints(10, 5, 10) 5~10사이 10개 반환
        intRanStr.limit(5).forEach(System.out::println); // limit(5) : 5개만 잘라라

        // iterate(T seed, UnaryOperator f) 단항 연산자
        Stream<Integer> intIter = Stream.iterate(1, n-> n+2); // 2++ 무한출력
        intIter.limit(10).forEach(System.out::println);

        //generate(Supplier s) : 주기만 하는 것 입력 X, 출력 O
        Stream<Integer> oneStream = Stream.generate(()->1); //1 무한 출력
        oneStream.limit(10).forEach(System.out::println);
    }
}

// + 파일을 한줄씩 읽어오는 스트림, 비어있는 스트림을 만들 수 있음
