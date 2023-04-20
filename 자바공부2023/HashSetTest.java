package 자바공부2023;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1), "2","2","3","3","4","4"};
        Set set = new HashSet();

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]); //HashSet에 objArr 요소 저장
        }

        System.out.println(set);

        //HashSet에 저장된 요소들을 출력(Iterator 사용)
        Iterator it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();
        set.clear();
        for (int i = 0; 6 > set.size(); i++) {
            int num = (int)(Math.random()*45)+1;
            set.add(num);
        }

        System.out.println(set);
        List list = new LinkedList(set); // LinkdList(Collection c)
        Collections.sort(list);          // Collections.sort(List list)
        System.out.println(list);
    }
}
