package 자바공부2023;

// [최종 연산]
// forEach() : 병렬스트림 경우 순서 보장X
// forEachOrdered() : 병렬스트림 경우 순서 보장
//      - 중간연산자 직렬로 변경 : sequential()
//      - 중간연산자 병렬로 변경 : parallel()

// allMatch(조건) : 모든 요소 조건 만족 -> true
// anyMatch(조건) : 한 요소라도 조건 만족 -> true
// noneMatch(조건) : 모든 요소 조건 만족 X -> true

// findFirst(조건) : 조건 일치하는 첫 번째 요소 반환 (순차 스트림에 사용)
// findAny(조건) : 조건 일치하는 아무 요소 반환 (병렬 스트림에 사용)

// reduce(초기값, 수행할 연산, 결과 합 연산(병렬)) : 요소를 하나씩 줄여가며 누적연산 수행

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "s1", "s2", "ddd", "fdse", "fa"};

        Stream.of(strArr)
                .parallel() // 병렬로 처리
                .forEachOrdered(System.out::println); // 병렬을 순서대로 출력

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s->s.charAt(0)=='s').findFirst();

        System.out.println("nonEmptyStr="+noEmptyStr);
        System.out.println("sWord="+sWord.get());

        // Stream<String[]>을 IntStream으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b)->a+1);
        int sum = intStream2.reduce(0,(a,b)->a+b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = IntStream.empty().reduce(Integer::min);
        System.out.println("count="+count);
        System.out.println("sum="+sum);
        System.out.println("max="+max.getAsInt()); // getAsInt() : int형으로 가져와라
        System.out.println("min="+min.orElse(0)); // 아무 값이 없으면 0 반환
    }
}
