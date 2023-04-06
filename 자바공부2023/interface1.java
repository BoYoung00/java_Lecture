package 자바공부2023;

// 인터페이스와 추상 클래스의 차이점 : 인터페이스는 iv와 생성자, 인스턴스 메서드를 가질 수 없다.

// 1번 예제
interface InterfaceName { //인터페이스 클래스 선언
    public static final int num = 1; //인터페이스는 인스턴스 변수를 가질 수 없고, 상수만 가능하다.
    String name="Hi"; //인터페이스의 모든 상수는 public static final을 가지므로 굳이 안 써줘도 된다.
    public abstract void information(int a); //추상 클래스와 마찬가지로 구현이 안된다. {} 사용xx
    void test(); //추상 메서드는 public abstract을 기본으로 가짐
}

// 2번 예제
interface Movable {
    void move(int x, int y);
}

interface Attackable {
    void attack(Unit u);
}

//인터페이스는 다중 상속이 가능하다. (추상 메서드는 출동해도 문제가 없기 때문 -> 구현이 안되있으니까)
interface Fightable extends Movable, Attackable {

}

// 3번 예제
class Fighter implements InterfaceName { // 인터페이스를 구현해주는 방법

    @Override
    public void information(int a) {
        System.out.println("구현");
    }

    @Override
    public void test() {
        System.out.println("구현");
    }
}

// 4번 예제
abstract class Fighter2 implements InterfaceName {
// 추상 메서드와 마찬가지로 모두 구현하지 않을 경우에는 class 제어자를 abstract로 지정해주면 된다.
    @Override
    public void information(int a) {
        System.out.println("구현");
    }
}

