package 자바공부2023;

import java.util.*;

import static java.util.Collections.*;

// Map : key, value
// 순차X
// HashMap : 많은 양의 데이터 검색 가능
// Map.Entry<> : Map 형태의 인터페이스 만듦
public class HashMapTest {
    public static void main(String[] args) {
        HashMapTest h = new HashMapTest();
        // h.dataList();
        h.scoreList();
        // h.login();
    }

    // 로그인 기능
    public void login() {
        HashMap map = new HashMap();
        map.put("id", "1234"); // 추가
        map.put("asdf", "1111");
        map.put("asdf", "2222");

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("ID와 PW를 입력하세요");
            System.out.print("ID : ");
            String id = in.nextLine().trim();

            System.out.print("PW : ");
            String pw = in.nextLine().trim();

            if (!map.containsKey(id)) {
                System.out.println("id가 존재하지 않습니다");
                continue;
            }
            if (!(map.get(id)).equals(pw)) {
                System.out.println("pw가 일치하지 않습니다.");
            } else {
                System.out.println("로그인 성공");
                break;
            }
        }
    }

    // 명단, 점수, 총점, 최고점수, 최저점수 출력
    public void scoreList() {
        HashMap map = new HashMap();
        map.put("김보영", new Integer(90));
        map.put("이두호", new Integer(100));
        map.put("김이응애", new Integer(80));

        Set set = map.entrySet(); // 키와 값을 set으로 변환
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("이름 : "+e.getKey());
        }

        set = map.keySet(); // 키를 set으로 변환
        System.out.println("참가자 명단 : "+set);

        Collection values = map.values();
        it = values.iterator();

        int total = 0;
        while (it.hasNext()) {
            int i = (int)it.next();
            total += i;
        }

        System.out.println("총점 : "+total);
        System.out.println("평균 : "+(float)total/set.size());
        System.out.println("최고점수 : "+max(values));
        System.out.println("최저점수 : "+Collections.min(values));
    }

    // 중복 알파벳 세기
    public void dataList() {
        String[] data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};

        HashMap map = new HashMap();

        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(data[i])) {
                int value = (int)map.get(data[i]);
                map.put(data[i], value+1);
            }else {
                map.put(data[i], 1);
            }
        }
        Iterator it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            int value = (int)entry.getValue();
            System.out.println(entry.getKey() + " : " +value);
        }
    }
}
