package 자바과제2023;

import java.util.*;

interface IOperation {
    void modify(); //수식입력
    void operatorLocation(); //연산자 위치 반환
    void result(); //결과값 반환
}

class Operation implements IOperation {
    private String input; // 수식 입력 받기
    private LinkedList<Double> operResult; // 피연산자
    private Queue<Character> operand; // 연산자
    private double FinalResult; // 최종 결과값 저장용
    Scanner in = new Scanner(System.in);

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public void modify() { //수식입력
        operand = new LinkedList<Character>(); // 초기화
        operResult  = new LinkedList<Double>(); // 초기화

        // 연산자 만나면 나눠서 피연산자만 저장
        String[] operator = input.split("\\+|\\-|\\*|\\/");

        for (int i = 0; i < operator.length; i++) {
            //String 타입 연산자를 double로 변환하여 저장
            operResult.add(Double.parseDouble(operator[i]));
        }
    }

    @Override
    public void operatorLocation() { //연산자 위치 반환 (큐에 연산자 입력)
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                operand.add('+');
                continue;
            }
            if (input.charAt(i) == '-') {
                operand.add('-');
                continue;
            }
            if (input.charAt(i) == '/') {
                operand.add('/');
                continue;
            }
            if (input.charAt(i) == '*') {
                operand.add('*');
            }
        }
    }

    public void multiplication(int index) { //곱하기
        double result = operResult.get(index) * operResult.get(index + 1); // *의 뒤에 숫자와 앞에 숫자를 곱함
        operResult.set(index, result); // 그 결과값을 왼쪽 피연산자에 저장
        operResult.remove(index + 1); // 오른쪽 피연산자 삭제
        FinalResult = operResult.get(0); // 수식이 바로 끝날 수 있으므로 첫번째 피연산자 값 저장
    }

    public void division(int index) { //나누기
        double result = operResult.get(index) / operResult.get(index + 1); // /의 뒤에 숫자와 앞에 숫자를 나눔
        operResult.set(index, result); // 그 결과값을 왼쪽 피연산자에 저장
        operResult.remove(index + 1); // 오른쪽 피연산자 삭제
        FinalResult = operResult.get(0); // 수식이 바로 끝날 수 있으므로 첫번째 피연산자 값 저장
    }

    @Override
    public void result() { // 결과값 반환
        FinalResult = 0;
        boolean resultBool = false;
        while (!operand.isEmpty()) {
            // 맨 끝자리가 연산자면 오류
            if (!(Character.isDigit(input.charAt(input.length()-1))))
                break;
            resultBool = true;
            LinkedList list = (LinkedList) operand;
            // 우선 연산자 *, / 찾기
            boolean mulbool = list.contains('*'); // * 존재 여부
            boolean divbool = list.contains('/'); // / 존재 여부
            int mulIndex = list.indexOf('*'); // *가 있는 곳의 index
            int divIndex = list.indexOf('/'); // /가 있는 곳의 index

            // *, / 연산자가 둘 다 존재할 경우
            if (mulbool && divbool) {
                if (mulIndex < divIndex) { // 연산자 *가 앞에(왼쪽)에 있을 때
                    multiplication(mulIndex);
                    list.remove(mulIndex); // *를 큐에서 삭제
                    continue;
                }
                if (mulIndex > divIndex) { // 연산자 /가 앞에(왼쪽)에 있을 때
                    division(divIndex);
                    list.remove(divIndex); // /를 큐에서 삭제
                    continue;
                }
            }
            // 연산자 * 찾기
            if (mulbool) {
                multiplication(mulIndex);
                list.remove(mulIndex); // *를 큐에서 삭제
                continue;
            }
            // 연산자 / 찾기
            if (divbool) {
                division(divIndex);
                list.remove(divIndex); // /를 큐에서 삭제
                continue;
            }
            // *, / 연산자를 모두 계산했을 경우
            FinalResult = operResult.get(0); // 첫번째 피연산자 저장
            for (int i = 1; i < operResult.size(); i++) {
                // 남은 +와 -를 큐를 이용하여 계산
                char arit = operand.poll();
                if (arit == '+') {
                    FinalResult += operResult.get(i);
                    continue;
                }
                if (arit == '-')
                    FinalResult -= operResult.get(i);
            } // for
        } //while
        if (resultBool == false) { //아무 계산이 이루어지지 않았을 때
            System.out.println("잘못된 수식입니다.");
        } else {
            System.out.println("결과 값 : " + FinalResult);
        }
    }
}

class OperationDemo {
    public static void main(String[] args) {
        Operation oper = new Operation();
        Scanner in = new Scanner(System.in);

        System.out.println("===== 사칙연산 계산기 (종료 : 0) =====");
        while (true) {
            System.out.print("수식을 입력하세요 : ");
            String input = in.nextLine(); // 수식 입력
            if (input.equals("0"))
                break;
            try {
                oper.setInput(input);
                oper.modify();
                oper.operatorLocation();
                oper.result();
            } catch (Exception e) {
                System.out.println("잘못된 수식입니다.");
            }
        }
    }
}
