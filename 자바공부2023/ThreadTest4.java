package 자바공부2023;

//동기화 : 작업중인 쓰레드를 다른 쓰레드가 간섭하지 못하게 막는 것
//synchronized : 자물쇠 걸기, 단 하나의 쓰레드만 자물쇠를 가질 수 있음. 자물쇠 사용을 끝내면 다른 쓰레드에게 넘겨줌
//단점 : 프로그램의 효율이 떨어진다.
public class ThreadTest4 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx1();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    private int balance = 1000;

    public synchronized int getBalance() {
        return balance; //잔고
    }

    // synchronized가 없다면 잔고가 0원이 되기 전에 다음 쓰레드가 들어와 버려서 마이너스 잔고가 되어 버림
    // 이를 방지하기 위해 synchronized를 사용
    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            balance -= money;
        }
    } //withdraw
}

class RunnableEx1 implements Runnable {
    Account acc = new Account();
    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            // 100, 200, 300 중의 한 값을 임으로 선택해서 출금
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }
}