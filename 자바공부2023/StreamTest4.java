package 자바공부2023;

import java.io.File;
import java.util.stream.Stream;

// 중간 연산자
// map() 파일 확장자를 중복없이 빼내기
// peek() 중간에 출력해서 확인 (forEach와 비슷.)
public class StreamTest4 {
    public static void main(String[] args) {
        File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")};

        Stream<File> fs = Stream.of(fileArr);

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> fns = fs.map(File::getName);
        fns.forEach(System.out::println);

        fs = Stream.of(fileArr);

        fs.map(File::getName)
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것 제외
                .peek(s-> System.out.printf("filename=%s%n",s))
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
                .peek(s-> System.out.printf("filename=%s%n",s))
                .map(String::toUpperCase) // 대문자 변환
                .distinct() // 중복제거
                .forEach(System.out::println);
    }
}
