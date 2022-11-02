import java.util.Scanner;

public class java1102_3 {
    public static void main(String[] args) {
        //4과목 성적을 가진 3명의 학생의 점수를 입력 받고, 학생별 평균 계산해서 출력, 반 평균 출력
        Scanner in = new Scanner(System.in);
        double[][] scores = new double [3][4];
        double avg = 0;
        double banavg = 0;

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d번째 학생 점수 입력 : \n",i+1);
            for (int j=0; j <scores[i].length; j++) {
                scores[i][j] = in.nextDouble();
                avg += (scores[i][j]) / scores[i].length;
            }
            banavg += avg;
            System.out.printf("%d번째 학생 평균 ==> %.1f\n", i+1, avg);
            avg = 0;
        }
        System.out.printf("반 평균 ==> %.1f", banavg / scores.length);
    }
}

