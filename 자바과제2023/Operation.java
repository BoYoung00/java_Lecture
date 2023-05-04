package 자바과제2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

interface IOperation {
    void modify(); //수식입력
    void operatorLocation(); //연산자 위치 반환
    void result(); //결과값 반환
}

class Operation implements IOperation {
    StringBuilder anOperand = new StringBuilder(); //피연산자(숫자)
    StringBuilder arithmetic = new StringBuilder(); //연산자(문자)
    String input; //수식 입력 받기
    String[] str; //수식 한 문자씩 자르기
    Scanner in = new Scanner(System.in);

    @Override
    public void modify() { //수식입력
        System.out.print("수식을 입력하세요 : ");
        input = in.nextLine(); // 수식 입력
        str = input.split(""); //문자 하나씩 나누기
    }

    @Override
    public void operatorLocation() { //연산자 위치 반환
        int cutIndex = 0;

        for (int i = 0; i < input.length(); i++){
            // 문자 중에 연산자를 찾으면 그 전부터 지금 문자까지 잘라서 저장
            if(str[i].equals("*") || str[i].equals("/") || str[i].equals("+") || str[i].equals("-")) {
//                double oper = Double.parseDouble(input.substring(cutIndex, i));
                String oper = input.substring(cutIndex, i);
                anOperand.append(oper); //피연산자
                cutIndex = i + 1;
            }
            if( (i+1)==input.length()){
                System.out.println(input.substring(cutIndex));
            }
        }

//        for (int i = 0; i < input.length(); i++) {
//            if (Character.isDigit(input.charAt(i))){ //문자가 숫자면
//                anOperand.append(input.charAt(i));
//            } else {
//                arithmetic.append(input.charAt(i));
//            }
//        }
//        System.out.println(anOperand);
//        System.out.println(arithmetic);
    }

    @Override
    public void result() { //결과값 반환

    }
}

class OperationDemo {
    public static void main(String[] args) {
//        Operation oper = new Operation();
//        oper.modify();


    }
}
