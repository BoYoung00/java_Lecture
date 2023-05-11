package 자바공부2023;

import javax.swing.*;

public class ThreadTest2 {
    public static void main(String[] args) {
        ThreadEx1 th1 = new ThreadEx1();
        th1.start();
        System.out.println("[main] isInterrupted():" + th1.isInterrupted()); // false
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt(); // interrupt()를 호출하면, interrupted상태가 true가 된다.
        System.out.println("[main] isInterrupted():" + th1.isInterrupted()); //true
        System.out.println("[main] isInterrupted():" + th1.isInterrupted()); //true
        // 현재 쓰레드가 interrupted 됐는지 보는 것이기 때문에 Thread.interrupted(); (static 메서드)
        // interrupted가 된건 th1이고, Thread 자기 자신은 아니니 false가 나옴
        System.out.println("[main] interrupted():" + Thread.interrupted()); //false
    }
}

class ThreadEx1 extends Thread {
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 2500000000L; x++); // 시간 지연
        }
        System.out.println("isInterrupted():" + this.isInterrupted()); //true
        System.out.println("isInterrupted():" + this.isInterrupted()); //true
        System.out.println("interrupted():" + Thread.interrupted()); //true
        System.out.println("interrupted():" + Thread.interrupted()); //false (상태 출력 후 false로 초기화 하므로)

        System.out.println("카운트가 종료되었습니다.");
    }
}
