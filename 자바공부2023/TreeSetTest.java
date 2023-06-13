package 자바공부2023;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

// Set : 중복X, 순서X, 자동 정렬
// TreeSet : 이진탐색트리, 정렬을 해줘서 검색에 유리하다
// [+참고] LinkedHashSet : Set에 순서 부여
public class TreeSetTest {
    public static void main(String[] args) {
        Set set1 = new TreeSet(); // 범위 검색, 정렬. 정렬 필요 없음
        Set set2 = new TreeSet(new TestComp());

        set1.add(new Test());
        set2.add(new Test2());

        System.out.println(set1);
        System.out.println(set2);

        TreeSet set3 = new TreeSet();
        set3.add(new Integer(1)); // Integer은 Comparable을 구현한 클래스이기 때문에 그냥 add 해줘도 된다
        System.out.println(set3);
        int [] score = {80,95,50,35,45,65,10,100};
        for (int i = 0; i < score.length; i++) {
            set3.add(new Integer(score[i]));
        }
        System.out.println("50보다 작은 값 : " + set3.headSet(50));
        System.out.println("50보다 큰 값 : " + set3.tailSet(50));
        System.out.println("40과 80사이의 값 : " + set3.subSet(40,80));

        TreeSet set4 = new TreeSet();
        set4.add("abc"); set4.add("def");set4.add("ghi");
        System.out.println(set4.subSet("a", "d"));

    }
}

// TreeSet은 객체를 add할 때 비교기준이 있어야 하므로 Comparable를 구현한 클래스를 생성해주어야한다.
class Test implements Comparable {
    @Override
    public int compareTo(Object o) {
        return -1;
    }
}

//비교 기준 없을 경우
class Test2 {}
// Test2에는 그 기준이 없기 때문에 TreeSet을 선언할 때 기준을 객체 추가 해야한다.
// 따라서 밑에 TestComp를 만들어 기준을 정해줌
class TestComp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return 1;
    }
}
