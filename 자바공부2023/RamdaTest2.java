package 자바공부2023;

@FunctionalInterface
interface MyFunction2 {
    void run();
}

public class RamdaTest2 {
    static void execute(MyFunction2 f) {
        f.run(); // MyFunction2의 run() 메서드를 호출한다.
    }

    static MyFunction2 getMyFunction2() {
        MyFunction2 f = () -> System.out.println("f3.run");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 run 구현
        MyFunction2 f1 = () -> System.out.println("f1.run()");

        MyFunction2 f2 = new MyFunction2() { //익명 클래스로 run 구현
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction2 f3 = () -> System.out.println("f3.run()");

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute( () -> System.out.println("run()") );
    }
}

