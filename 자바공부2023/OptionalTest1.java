package 자바공부2023;


import java.sql.Struct;
import java.util.Optional;

// Optional : null을 다루기 위함
// 1. NullPointerException 발생 위험 줄임
// 2. if문 사용을 줄이기 위함
public class OptionalTest1 {
    public static void main(String[] args) {
        // int[] arr = null;
        int[] arr = new int[0];
        System.out.println("arr.length="+arr.length);

        // Optional<String> opt = null; // OK. 하지만 바람직X
        Optional<String> opt = Optional.empty(); // 비어있는 값 생성
        // Optional<String> opt = Optional.of("abc");

        System.out.println("opt="+opt);
        // System.out.println("opt="+opt.get()); // 오류떠서 잘 안 씀

        String str = "";

//        try {         // 번거러워서 이렇게 안함
//            str = opt.get();
//        }catch (Exception e) {
//            str = ""; // 예외가 발생하면 빈문자열("")로 초기화
//        }

        // str=opt.orElse("EMPTY"); // OPtional에 저장된 값이 null이면 "" 반환
        // str=opt.orElseGet(()->new String()); // 위와 같은 기능, 람다식 사용가능
        str=opt.orElseGet(String::new);
        System.out.println("str="+str);


    }
}
