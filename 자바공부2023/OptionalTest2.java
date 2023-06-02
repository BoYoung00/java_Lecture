package 자바공부2023;

import java.util.Optional;
import java.util.OptionalInt;

// isPresent() : 객체의 값이 null이면 false, 아니면 true
// orElseGet(String::new) : 값이 null이면 람다식으로 값 생성
// orElseThrow(NullPointerException::new) : 값이 null이면 예외처리
public class OptionalTest2 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length); // 글자 수 반환

        System.out.println("optStr="+optStr.get());
        System.out.println("optInt="+optInt.get());

        int result1 = Optional.of("123")
                .filter(x->x.length()>0)
                .map(Integer::parseInt).get();

        int result2 = Optional.of("")
                .filter(x->x.length()>0)
                .map(Integer::parseInt).orElse(-1);

        System.out.println("result1="+result1);
        System.out.println("result2="+result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x-> System.out.printf("result3=%d%n",x));

        OptionalInt optInt1 = OptionalInt.of(0); // 0을 저장 isPresent : true
        OptionalInt optInt2 = OptionalInt.empty(); // 빈 객체를 생성 isPresent : false

        System.out.println(optInt1.isPresent()); //true
        System.out.println(optInt2.isPresent()); //false

        System.out.println(optInt1.getAsInt()); //0
        // System.out.println(optInt2.getAsInt()); //NoScuchElementException
        System.out.println("optInt1="+optInt1);
        System.out.println("optInt2="+optInt2);
        System.out.println("optInt1.equals(optInt2)?"+optInt1.equals(optInt2));
    }
}
