package 자바강의2023.week2;

import java.util.Iterator;
import java.util.Scanner;

public class PrimeTest2 {

    Scanner input = new Scanner(System.in);

    int inpuData(int loop) {
        System.out.println(loop+1+"번째 정수 입력 : ");
        return input.nextInt();
    }

    boolean isPrime(int num) {
        if(num == 1) {
            return true;
        }
        int temp;
        for (int i = 2; i <= num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        PrimeTest2 num = new PrimeTest2();
        int count;

        for(int i=0;;i++) {
            count = num.inpuData(i);
            if(count <= 0) break;
            if (num.isPrime(count)) {
                System.out.println("소수입니다.");
            }else {
                System.out.println("소수가 아닙니다.");
            }
        }

    }
}
