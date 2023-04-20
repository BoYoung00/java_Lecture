package 자바공부2023;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set set1 = new TreeSet(); // 범위 검색, 정렬. 정렬 필요 없음
        Set set2 = new TreeSet(new TestComp());

        set1.add(new Test());
        set2.add(new Test2());

        System.out.println(set1);
        System.out.println(set2);
    }
}

// TreeSet은 객체를 add할 때 비교기준이 있어야 하므로 Comparable를 구현한 클래스를 생성해주어야한다.
class Test implements Comparable {
    @Override
    public int compareTo(Object o) {
        return -1;
    }
}

//비교 기준 없음 경우
class Test2 {}
// Test2에는 그 기준이 없기 때문에 TreeSet을 선언할 때 기준을 객체 추가 해야한다.
// 따라서 밑에 TestComp를 만들어 기준을 정해줌
class TestComp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return 1;
    }
}
