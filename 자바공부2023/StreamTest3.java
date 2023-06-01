package 자바공부2023;

import java.util.Comparator;
import java.util.stream.Stream;

// 중간 연산자
// sorted 정렬
public class StreamTest3 {
    public static void main(String[] args) {
        Stream<Student> s = Stream.of(
                new Student("김보영", 1, 200),
                new Student("이두호", 1, 300),
                new Student("가나다", 2, 100),
                new Student("자바라", 2, 250),
                new Student("바나나", 3, 170),
                new Student("정상수", 2, 290),
                new Student("김용명", 3, 180)
                );
        s.sorted(Comparator.comparing(Student::getBan) // 1. 반별 정렬
                .thenComparing(Comparator.naturalOrder())) // 2. 기본 정렬
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", totalScore=" + totalScore +
                '}';
    }

    public String getName() {return name;}

    public int getBan() {return ban;}

    public int getTotalScore() {return totalScore;}

    @Override
    public int compareTo(Student s) { // 총점 내림차순
        return s.totalScore - this.totalScore;
    }
}
