package 자바강의2023.week2;

import java.util.Scanner;

class AverageInt {
    private int cnt = 0;
    private int sum = 0;
    private double average = 0.0;

    public double getAverage() {
        return average;
    }

    Scanner input = new Scanner(System.in);

    public void inputData() {
        int num;
        for (int i = 1;; i++) {
            System.out.print(i+"번째 정수 입력 : ");
            num = input.nextInt();
            if(num <= 0) break;
            cnt ++;
            sum += num;
        }
        this.average = ((double)sum / cnt);
    }
}

public class AverageIntEx {

    public static void main(String[] args) {
        AverageInt avg = new AverageInt();
        avg.inputData();
        System.out.println("평균 : " + avg.getAverage());

    }

}
