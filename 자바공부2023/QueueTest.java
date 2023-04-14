package 자바공부2023;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueTest { //최근 5개 이력 보여주기 기능
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.print(">> ");

            try {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine().trim();

                if ("".equals(input)) continue;

                if (input.equalsIgnoreCase("q")) {
                    System.exit(0); //프로그램 정상 종료
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말");
                    System.out.println(" q 또는 Q - 프로그램 종료");
                    System.out.println(" history - 최근 입력한 명령어 ("+MAX_SIZE+"개)");
                } else if (input.equalsIgnoreCase("history")) {
                    save(input);

                    LinkedList list = (LinkedList)q;

                    final int SIZE = list.size(); //실무에서는 반복횟수가 많을 수 있으니 이렇게 작성하기
                    for (int i = 0; i < SIZE; i++) {
                        System.out.println((i+1)+"."+list.get(i));
                    }
                } else {
                    save(input);
                    System.out.println(input);
                }
            }catch (Exception e) {
                System.out.println("입력오류입니다.");
            }
        } //while
    } //main
    public static void save(String input) {
        if (!"".equals(input)) //if(input!=null && !input.equals(""))
            q.offer(input); //저장
        if (q.size() > MAX_SIZE)
            q.poll(); //제일 처음에 들어갔던 값이 삭제됨 (remove)
    }
} // end of class

