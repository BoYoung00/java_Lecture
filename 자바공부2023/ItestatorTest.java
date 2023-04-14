package 자바공부2023;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class ItestatorTest {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        //Iterator은 Collection 인터페이스에 선언되어 있는 메서드이기 때문에 이를 구현한 list 클래스를 통하여 반환해야 함
        Iterator it = list.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            System.out.print(obj + " ");
        }

        System.out.println();

        //이미 위에서 끝에까지 읽었기 때문에 실행되지 않음
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.print(obj + " ");
        }

        System.out.println();

        it = list.iterator(); //다시 iterator을 얻어오면 다시 쓸 수 있음 (1회용)
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.print(obj + " ");
        }

        System.out.println();

        //HashSet()을 사용한 list는 밑의 코드가 실행되지 않음. (get()메서드가 없기 때문)
//        for (int i = 0; i < list.size(); i++) {
//            Object obj = list.get(i);
//            System.out.print(obj + " ");
//        }
    }
}
