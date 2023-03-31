package 자바공부2023;

abstract class Unit { //추상 메서드 (리모컨) / 추상으로 만든 이유는 리모컨 클래스로 객체를 만들 수 없게 하기 위함
    // 자식 클래스들이 공통적으로 사용하는 메서드 모음
    int x, y;
    abstract void move(int x, int y);
    void stop() {
        System.out.println("정지");
    };
}

class Marine extends Unit { //보병
    void move(int x, int y) {
        System.out.println(x +", "+ y + "로 보병 이동");
    }
    void stimPack() {
        System.out.println("스팀팩 사용");
    }
}

class Tank extends Unit { //탱크
    void move(int x, int y) {
        System.out.println(x +", "+ y + "로 탱크 이동");
    }
    void changeMode() {
        System.out.println("공격모드");
    }
}

class Dropship extends Unit { //수송선
    void move(int x, int y) {
        System.out.println(x +", "+ y + "로 수송선 이동");
    }
    void load() {
        System.out.println("대상 태우기");
    }
    void unload() {
        System.out.println("대상 내리기");
    }
}

public class abstractClass2 {
    public static void main(String[] args) {
        // 부모 클래스 타입의 배열을 만들어서 그 안에 자식 클래스 객체를 생성하여 한꺼번에 메서드를 실행 시킴(리모콘)
        Unit[] group = new Unit[3];
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new Dropship();

        for (int i = 0; i < group.length; i++) {
            group[i].move(100, 200);
            //group 배열의 타입은 부모 클래스(Unit)에 move 메서드가 있기 떄문에
            //자식 클래스에서 오버라이딩한 것을 호출하여 사용할 수 있음
            //ex) 리모콘에 move 버튼이 있고 없고를 생각하면 됨
        }
    }
}
