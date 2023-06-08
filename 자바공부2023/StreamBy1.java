package 자바공부2023;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

// collect() : 최종연산, Stream의 데이터를 변형 등의 처리를 하고 원하는 자료형으로 변환
//            -> List 또는 Set 변환, joining, Sorting, 평균 값 리턴
// collect(partitioningBy()) : 스트림을 2분할
class StudentBy {
    String name;
    boolean isMale; //성별
    int hak;    // 학년
    int ban;    // 반
    int score;

    public StudentBy(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return '[' + name +
                ", " + isMale +
                ", " + hak +
                ", " + ban +
                ", " + score +
                ']';
    }
    // gropingBy()에서 사용
    enum Level { HIGH, MID, LOW } // 성적을 상, 중, 하 세 단계로 분류

}

public class StreamBy1 {
    public static void main(String[] args) {
        StudentBy[] stuArr = {
                new StudentBy("나자바", true, 1, 1, 300),
                new StudentBy("김지미", false, 2, 1, 180),
                new StudentBy("김자바", true, 3, 3, 80),
                new StudentBy("이지미", false, 2, 1, 200),
                new StudentBy("남자바", true, 1, 2, 150),
                new StudentBy("이자바", true, 1, 1, 250),
                new StudentBy("안지미", false, 3, 3, 200),
                new StudentBy("김지미", false, 2, 2, 100)
        };

        // 성별로 단순 2분할 (isMale)
        // 분할 기준이 되는 true, false는 Boolean에 담고, 그 결과를 List<StudentBy>에 담는다
        System.out.println("1. 단순분할(성별로 분할)");
        Map<Boolean, List<StudentBy>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentBy::isMale));


        List<StudentBy> maleStudent = stuBySex.get(true); // key 값 true는 남자 value 반환(list 타입)
        List<StudentBy> femaleStudent = stuBySex.get(false); // key 값 false는 여자 value 반환

        for (StudentBy s : maleStudent) System.out.println(s);
        for (StudentBy s : femaleStudent) System.out.println(s);

        // 성별 2분할 후 그 결과를 counting()으로 개수를 세서 넣는다
        // 분할 기준이 되는 true, false는 Boolean에 담고, 그 결과의 개수를 Long에 담는다
        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentBy::isMale, counting()));

        System.out.println("남학생 수 : " + stuNumBySex.get(true));
        System.out.println("여학생 수 : " + stuNumBySex.get(false));

        // 성별 2분할 후 그 결과에서 점수 1등의 내역을 넣는다
        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<StudentBy>> toScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentBy::isMale, // 남여(t,f)로 분할
                        maxBy(comparingInt(StudentBy::getScore)) // 그것을 Score에서 최대값만 구해서 넣음
                ));
        System.out.println("남학생 1등 : " + toScoreBySex.get(true));
        System.out.println("여학생 1등 : " + toScoreBySex.get(false));
        // 위와 같은 기능, collectingAndThen()에서 Optional::get 사용
        // collectingAndThen() : Collecting을 진행한 후 그 결과로 메서드를 하나 더 호출 할 수 있게 해줌
        Map<Boolean, StudentBy> toScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(StudentBy::isMale,
                        collectingAndThen(maxBy(comparingInt(StudentBy::getScore)),
                                Optional::get) // 분할한 값을 Optional 클래스에서 get해서 값만 반환한다
                ));
        System.out.println("남학생 1등 : " + toScoreBySex2.get(true));
        System.out.println("여학생 1등 : " + toScoreBySex2.get(false));

        // 성별로 2분할 후 다시 조건을 줘서
        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");
        Map<Boolean, Map<Boolean, List<StudentBy>>> failedStuBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentBy::isMale, // 성별로 2분할
                        partitioningBy(s -> s.getScore() <= 100)) // 그 값을 다시 2분할하는데 score가 100점 이하인 것의 값을 List<StudentBy>에 반환
                );
        List<StudentBy> failedMaleStu = failedStuBySex.get(true).get(true); // 2중 맵 get하기 (남자, 100점 이하)
        List<StudentBy> failedFemaleStu = failedStuBySex.get(false).get(true); // (여자, 100점 이하)

        for (StudentBy s : failedMaleStu) System.out.println(s);
        for (StudentBy s : failedFemaleStu) System.out.println(s);
    }
}
