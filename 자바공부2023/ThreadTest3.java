package 자바공부2023;

import static java.lang.System.gc;

//void join() : 작업이 모두 끝날 때까지 기다린다.
//void join() : 1/1000초 동안
//void join() : 1/1000초 + 나노초 동안
public class ThreadTest3 {
    static long startTime = 0;
    public static void main(String[] args) {
        ThreadEx2_1 th1 = new ThreadEx2_1();
        ThreadEx2_2 th2 = new ThreadEx2_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis(); // 시작시간

        try {
            th1.join(); // main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join(); // main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        }catch (InterruptedException e) { }
        System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
    }

}

class ThreadEx2_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    } //run
}

class ThreadEx2_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    } //run
}

//join의 사용 예
//메모리 부족 시 잠자고 있는 쓰레드 gc를 깨운다.
//메모리를 사용하기 전에 gc.join(100);을 실행시켜 gc를 기다린다.
//그 뒤에 메모리를 사용한다.

//yield() : 다음 쓰레드에게 양보, 자신은 실행대기
//          -> 자기 자신에게만 사용 가능한 메서드)
class MyThreadEx3 implements Runnable {
    boolean suspended = false; //일시정지 상태
    boolean stopped = false;

    Thread th;

    MyThreadEx3(String name) {
        th = new Thread(this, name);
    }
    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                // 작업수행
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            } else {
                Thread.yield(); //양보, OS스케줄러에게 통보
                // 사실 속도 차이는 크지 않음
            }
        }
    }
}


