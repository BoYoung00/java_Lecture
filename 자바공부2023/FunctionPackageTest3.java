package 자바공부2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//  인터페이스   |                     메서드                      |            설명
// Collection    boolean removeIf(Predicate<E> filfer)             조건에 맞는 요소 삭제
// List          void replaceAll(UnaryOperator<E> operator)        모든 요소를 변환하여 대체
// Iterable      void forEach(Consumer<T> action)                  모든 요소에 작업 action을 수행
// Map           compute(K key, BiFunction<K,V,V> f)               지정된 키의 값에 작업 f를 수행
//               computeIfAbsent(K key, Function<K,V> f)           키가 없으면 작업 f 수행 후 추가
//               computeIfPresent(K key, BiFunction<K,V,V> f)      지정된 키가 없을 때 작업 f 수행
//               merge(K key, V value, BiFunction<K,V,V> f)        모든 요소에 병합작업 f 수행
//               forEach(BiConsumer<K,V> action)                   모든 요소에 작업 action 수행
//               replaceAll(BiFunction<K,V,V> f)                   모든 요소에 치환작업 f 수행
public class FunctionPackageTest3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        // list의 모든 요소를 출력
        list.forEach(i-> System.out.print(i+", "));
        System.out.println();

        // list에서 2또는 3의 배수를 제거한다.
        list.removeIf(x -> x%2 ==0 || x%3==0);
        System.out.println(list);

        // list의 각 요소에 10을 곱한다.
        list.replaceAll(i->i*10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map의 모든 요소를 {k, v} 형식으로 출력한다.
        map.forEach((k, v) -> System.out.print("{"+k+", "+v+"}"));
        System.out.println();
    }
}
