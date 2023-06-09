package 자바공부2023;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


// mapping() : 각 그룹의 요소를 집합으로 수집하기 전에 변형할 수 있게 해줌
public class StreamBy2 {
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

        // 반별 그룹화
        System.out.println("1. 단순그룹화(반별로 그룹화)");
        Map<Integer, List<StudentBy>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(StudentBy::getBan));

        for (List<StudentBy> ban : stuByBan.values())
            for (StudentBy s : ban)
                System.out.println(s);

        // 레벨로 그룹화
        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<StudentBy.Level, List<StudentBy>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200)        return StudentBy.Level.HIGH;
                    else if (s.getScore() >= 100)   return StudentBy.Level.MID;
                    else                            return StudentBy.Level.LOW;
                }));
        // 검색, 정렬에 유리
        TreeSet<StudentBy.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (StudentBy.Level key : keySet) {
            System.out.println("["+key+"]");

            for (StudentBy s : stuByLevel.get(key)) //
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<StudentBy.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200)        return StudentBy.Level.HIGH;
                    else if (s.getScore() >= 100)   return StudentBy.Level.MID;
                    else                            return StudentBy.Level.LOW;
                }, counting())); // 조건에 해당하는 학생 수 카운팅
        for (StudentBy.Level key : stuCntByLevel.keySet()) // keySet() : 모든 key 값 반환
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        System.out.println();

        System.out.printf("%n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<StudentBy>>> stuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(StudentBy::getHak,
                                groupingBy(StudentBy::getBan)
                        ));
        for (Map<Integer, List<StudentBy>> hak : stuByHakAndBan.values()) {
            for (List<StudentBy> ban : hak.values()) {
                System.out.println();
                for (StudentBy s : ban)
                    System.out.println(s);
            }
        } //for

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, StudentBy>> topStuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(StudentBy::getHak,
                                groupingBy(StudentBy::getBan,
                                        collectingAndThen(
                                                maxBy(comparingInt(StudentBy::getScore)) // 가장 높은 score 값 
                                                , Optional::get // 결과가 Optional이기 때문에 거기서 get해온다
                                        )
                                )
                        ));

        for (Map<Integer, StudentBy> ban : topStuByHakAndBan.values())
            for (StudentBy s : ban.values())
                System.out.println(s);

        System.out.printf("%n6. 다중그룹화 + 통계(학년, 반별 성적그룹)%n");
        Map<String, Set<StudentBy.Level>> stuByScoreGrop = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s-> {
                            if (s.getScore() >= 200)        return StudentBy.Level.HIGH;
                            else if (s.getScore() >= 100)   return StudentBy.Level.MID;
                            else                            return StudentBy.Level.LOW;
                        }, toSet()) // 매핑 이후에 적용, 중복제거
                ));
        Set<String> keySet2 = stuByScoreGrop.keySet();

        for (String key : keySet2)
            System.out.println("["+key+"]"+stuByScoreGrop.get(key));
    } //main
}
