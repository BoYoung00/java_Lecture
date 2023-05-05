package 자바과제2023;

import java.util.*;

interface IOperation {
    void modify(); //수식입력
    void operatorLocation(); //연산자 위치 반환
    void result(); //결과값 반환
}

class Operation implements IOperation {
    String input; //수식 입력 받기
    Double[] anOperand;
    Queue<Character> arithmetic = new LinkedList<Character>(); //연산자
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
            if(input.charAt(i)=='+') {
                arithmetic.add('+');
                continue;
            }
            if(input.charAt(i)=='-') {
                arithmetic.add('-');
                continue;
            }
            if(input.charAt(i)=='/') {
                arithmetic.add('/');
                continue;
            }
            if(input.charAt(i)=='*') {
                arithmetic.add('*');
                continue;
            }
        }
//        Iterator iter = arithmetic.iterator();
//
//        while(iter.hasNext())
//            System.out.print(iter.next() + " ");

    }

    @Override
    public void result() { //결과값 반환
//        result = Double.parseDouble(anOperand[0]);
        double result = 0;

        for (int i = 1; i < anOperand.length; i++) {
            try {
                char arit = arithmetic.poll();
                LinkedList list = (LinkedList) arithmetic;
                if (list.indexOf('*') >= 0) {
                    int cutIndex = list.indexOf('*');
                    result = anOperand[cutIndex-1] * anOperand[cutIndex+1];
                    anOperand[cutIndex-1] = result;

                    if (arit == '+') {
                        result += anOperand[i];
                        continue;
                    }
                    if (arit == '-') {
                        result -= anOperand[i];
                        continue;
                    }
                }



            } catch (Exception e) {
                System.out.println("잘못된 수식입니다.");
                break;
            }
        }
    }
}

class OperationDemo {
    public static void main(String[] args) {
        Operation oper = new Operation();
        oper.modify();
//        oper.operatorLocation();


    }
}
