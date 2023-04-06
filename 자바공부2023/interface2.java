package 자바공부2023;

abstract class Unit2 {
    int x,y;
    abstract void move(int x, int y);
    void stop() {System.out.println("멈춥니다.");}
}

interface Fightable2 {
    void move(int x, int y); //public abstract가 생략됨
    void attack(Fightable2 f); //public abstract가 생략됨

}

class Fighter3 extends Unit2 implements Fightable2 {
    public void move(int x, int y) {System.out.println(x + ", " + y + "로 이동");}
    public void attack(Fightable2 f) {System.out.println(f + "를 공격");}

    Fightable2 getFightable() { //Fighter3를 생성해서 반환
        Fighter3 f = new Fighter3();
        return f;
    }
}

public class interface2 {
    public static void main(String[] args) {
        Unit2 u = new Fighter3(); 
        Fightable2 f = new Fighter3();

        u.move(100,200);
//        u.attack(new Fighter3()); // Unit2에는 attack()이 없어서 호출 불가
        u.stop();

        f.move(100, 200);
        f.attack(new Fighter3()); // 밑에 두 줄과 같은 말
        Fighter3 f2 = new Fighter3();
        f.attack(f2);
//        f.stop(); // Fighter3에는 stop()이 없어서 호출 불가

        Fighter3 f1 = new Fighter3();
        Fightable2 ff2 = f1.getFightable();

    }
}
