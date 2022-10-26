import java.util.Scanner;

public class java1026_2과제 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("연산자 종류(1:+, 2:-, 3:*, 4:/)(정수입력) : ");
        int operators = in.nextInt();
        System.out.printf("첫번째 정수 : ");
        double num1 = in.nextDouble();
        System.out.printf("두번째 정수 : ");
        double num2 = in.nextDouble();

        double result = calculatr(operators, num1, num2);
        System.out.printf("계산결과 : %.1f", result);

    }
    public static double calculatr(int opr, double num1, double num2) {
        double result = 0;

        switch (opr){
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;
        }
        return result;
    }
}
