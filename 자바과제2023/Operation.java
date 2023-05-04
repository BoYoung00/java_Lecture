package 자바과제2023;

import java.util.Scanner;

interface IOperation {
    void modify(); //수식입력
    int[] operatorLocation(); //연산자 위치 반환
    void result(); //결과값 반환
}

class Operation implements IOperation {
    String input; //수식입력
    StringBuilder anOperand = new StringBuilder(); //피연산자(숫자)
    StringBuilder arithmetic = new StringBuilder(); //연산자(문자)
    Scanner in = new Scanner(System.in);

    @Override
    public void modify() { //수식입력
        System.out.print("수식을 입력하세요 : ");
        input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))){ //문자가 숫자면
                anOperand.append(input.charAt(i));
            } else {
                arithmetic.append(input.charAt(i));
            }
        }
        System.out.println(anOperand);
        System.out.println(arithmetic);
    }

    @Override
    public int[] operatorLocation() { //연산자 위치 반환
        return null;
    }

    @Override
    public void result() { //결과값 반환

    }
}

class OperationDemo {
    public static void main(String[] args) {
        Operation oper = new Operation();
        oper.modify();
    }
}
