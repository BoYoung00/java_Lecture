package 자바과제2023;

import java.util.Random;
import java.util.Scanner;

public class RPSgame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        String[] RPS = {"가위", "바위", "보"};

        System.out.println("<<가위 바위 보 게임>>");
        while (true) {
            try {
                int randVal = r.nextInt(3); //컴퓨터
                System.out.print("가위(0), 바위(1), 보(2) : ");
                int val = in.nextInt();

                if (val == -1) break;

                System.out.println("당신 : " + RPS[val]);
                System.out.println("컴퓨터 : " + RPS[randVal]);

                if (val == 0) {
                    if (randVal == 1) {
                        System.out.println("패배!");
                    } else if (randVal == 2) {
                        System.out.println("승리!");
                    } else {
                        System.out.println("무승부!");
                    }
                    continue;
                }
                if (val == 1) {
                    if (randVal == 0) {
                        System.out.println("승리!");
                    } else if (randVal == 2) {
                        System.out.println("패배!");
                    } else {
                        System.out.println("무승부!");
                    }
                    continue;
                }
                if (val == 2) {
                    if (randVal == 0) {
                        System.out.println("패배!");
                    } else if (randVal == 1) {
                        System.out.println("승리!");
                    } else {
                        System.out.println("무승부!");
                    }
                    continue;
                }

            } catch (Exception e) {
                System.out.println("0~2 사이의 숫자를 입력해주세요.");
            }
        }

    }
}
