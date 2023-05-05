package 자바과제2023;

import java.util.*;

interface IOperation {
    void modify(); //수식입력
    void operatorLocation(); //연산자 위치 반환
    void result(); //결과값 반환
}

class Operation implements IOperation {
    private String input; // 수식 입력 받기
    private Double[] anOperand; // 피연산자
    private LinkedList<Character> arithmetic = new LinkedList<Character>(); // 연산자
    Scanner in = new Scanner(System.in);

    @Override
    public void modify() { //수식입력
        System.out.print("수식을 입력하세요 : ");
        input = in.nextLine(); // 수식 입력
        String[] operator = input.split("\\+|\\-|\\*|\\/"); // 연산자 만나면 나누기
        anOperand = new Double[operator.length]; // 더블형 연산자 배열 크기 지정

        for (int i = 0; i < operator.length; i++) {
            anOperand[i] = Double.parseDouble(operator[i]); //String 타입 연산자를 double로 변환하여 저장
        }
        System.out.println(Arrays.stream(anOperand).toList());
    }

    @Override
    public void operatorLocation() { //연산자 위치 반환
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                arithmetic.add('+');
                continue;
            }
            if (input.charAt(i) == '-') {
                arithmetic.add('-');
                continue;
            }
            if (input.charAt(i) == '/') {
                arithmetic.add('/');
                continue;
            }
            if (input.charAt(i) == '*') {
                arithmetic.add('*');
                continue;
            }
        }
        Iterator iter = arithmetic.iterator();

        while (iter.hasNext())
            System.out.print(iter.next() + " ");

    }

    @Override
    public void result() { //결과값 반환
        double FinalResult = 0;
        while (!arithmetic.isEmpty()) {
            try {
                // 우선 연산자 *, / 찾기
                boolean mulbool = arithmetic.contains('*');
                boolean divbool = arithmetic.contains('/');
                if (mulbool || divbool) {
                    int mulIndex = arithmetic.indexOf('*'); // *가 있는 곳의 index
                    int divIndex = arithmetic.indexOf('/'); // /가 있는 곳의 index

                    if (mulbool || (mulbool && divbool && mulIndex < divIndex) ) { // 연산자 *가 있을 때
                        double result = anOperand[mulIndex - 1] * anOperand[mulIndex + 1]; // *의 뒤에 숫자와 앞에 숫자를 곱함
                        anOperand[mulIndex - 1] = result; // 그 값을 *의 뒤에 값으로 저장
                        arithmetic.remove(mulIndex); // *를 큐에서 삭제
                        continue;
                    }


                }
                // 우선 연산자 / 찾기
//                if (arithmetic.contains('/')) {
//
//                    double result = anOperand[divIndex - 1] / anOperand[divIndex]; // /의 뒤에 숫자와 앞에 숫자를 나눔
//                    anOperand[divIndex - 1] = result; // 그 값을 /의 뒤에 값으로 저장
//                    arithmetic.remove(divIndex); // /를 큐에서 삭제
//                    continue;
//                }

                FinalResult = anOperand[0]; //첫번째 피연산자는 그냥 넣어줌
                for (int i = 1; i < anOperand.length; i++) {
                    // 남은 +와 -를 큐를 이용하여 계산
                    char arit = arithmetic.poll();
                    if (arit == '+') {
                        FinalResult += anOperand[i];
                        continue;
                    }
                    if (arit == '-') {
                        FinalResult -= anOperand[i];
                        continue;
                    }
                } // for
            } catch (Exception e) {
                System.out.println("잘못된 수식입니다.");
                break;
            } //catch
        } //while
    }
}

class OperationDemo {
    public static void main(String[] args) {
        Operation oper = new Operation();
        oper.modify();
//        oper.operatorLocation();


    }
}
