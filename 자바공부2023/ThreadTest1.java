package 자바공부2023;

// suspend() : 쓰레드 일시정지
// resume() : suspend()에 의해 일시정지된 스레기를 실행대기로 만듦
// stop() : 쓰레드 즉시 종료
// 위 3가지는 deprecated이다. (사용 권장 X)

class ThreadTest1 implements Runnable{
    static  boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadTest1()); // Thread(Runnable r)
        // 데몬 쓰레드 (보조 쓰레드)
        t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다.
        t.start(); //쓰레드 시작

        for (int i = 1; i <= 10; i++) {
            try {
                // sleep은 자기 자신 밖에 재우지 못 한다.
                // t.sleep 하면 main이 잠듦
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(i);
            
            if(i==5) autoSave = true;
        }
        System.out.println("프로그램을 종료합니다.");
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000); //3초마다
            } catch (InterruptedException e) {}

            // autiSave의 값이 true이면 autoSave()를 호출한다.
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업파일을 자동저장되었습니다.");
    }
}


