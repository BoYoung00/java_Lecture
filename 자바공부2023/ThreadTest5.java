package 자바공부2023;

import java.util.ArrayList;

// wait() : 쓰레드를 기다리게 함
// notify() : 기다리는 쓰레드를 다시 실행 시킴 (랜덤)
class Customer implements Runnable {
    private Table table;
    private String food;

    public Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a "+ food);
        } //while
    }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) {this.table = table;}

    @Override
    public void run() {
        while (true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try {Thread.sleep(10);} catch (InterruptedException e) { }
        }
    }
}

class Table {
    String[] dishNames = {"dount", "donut", "burger"}; //도넛의 확률 높임
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try {
                wait(); //COOK쓰레드를 기다리게 한다.
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        dishes.add(dish);
        notify(); // 대기시킨 쓰레드 실행
        System.out.println("Dishes:"+dishes.toString());
    }

    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            while (dishes.size()==0) {
                System.out.println(name+" is waiting.");
                try {
                    wait(); //CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify(); // 대기시킨 쓰레드 실행
                        return;
                    }
                } //for

                try {
                    System.out.println(name+" is waiting.");
                    wait(); //COOK쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            } //while
        } //synchronized
    }
    public int dishNum() { return dishNames.length; }
}
public class ThreadTest5 {
    public static void main(String[] args) throws Exception {
        Table table = new Table();

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "donut"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);
    }
}

// 위 방법을 쓸 경우 wait하고 있는 쓰레드들을 같은 대기실에 있기 때문에 notify 시킬 때 어떤 쓰레드가 올지 모른다.
// 이를 보완한 것이 Lock & Condition 이다.