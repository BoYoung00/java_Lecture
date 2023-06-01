package 자바공부2023;

import java.util.Arrays;
import java.util.stream.Stream;


// flatMap 스트림의 스트림을 스트림으로 변환
// 여러 배열을 하나로 뭉치기
public class StreamTest5 {
    public static void main(String[] args) {
        Stream<String[]> strArr = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
                );

        Stream<String> strSt = strArr.flatMap(Arrays::stream);

        strSt.map(String::toLowerCase) // 소문자
                .distinct() // 중복제거
                .sorted() // 정렬
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try",
        };

        Stream<String> lineSt = Arrays.stream(lineArr);
        lineSt.flatMap(line -> Stream.of(line.split(" +"))) // " +" : 1개 이상의 공백 (정규식)
                .map(String::toLowerCase) // 소문자
                .distinct() // 중복제거
                .sorted() // 정렬
                .forEach(System.out::println);
    }
}
