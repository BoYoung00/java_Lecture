package 자바공부2023;

class A {
//    public void method(B b) {
//        b.method();
//    }
    public void method(I i) { //인터페이스 I를 구현한 것만 들어와라
        i.method();
    }
}

// B클래스의 선언과 수현을 분리
interface I {
    public void method();
}

class B implements I{
    public void method() {
        System.out.println("B클래스의 메서드");
    }
}

class C implements I{
    public void method() {
        System.out.println("C클래스의 메서드");
    }
}

public class interfaceTest {
    public static void main(String[] args) {
        A a = new A();
//        a.method(new B()); // A가 B를 사용 (의존)
//        a.method(new C()); // A가 C를 사용 (의존) / C 클래스를 의존하여 A를 실행시키기 위해서는 A 클래스도 수정을 거쳐야 함
        a.method(new B());
        a.method(new C());
    }
}
