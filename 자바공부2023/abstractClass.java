package 자바공부2023;

import org.w3c.dom.ls.LSOutput;

abstract class player { //추상 메서드
    abstract void play(int pos); //추상 메서드는 {}몸통 없다
    abstract void stop();
    int currentPos;
    void play() {
        play(currentPos);
        //호출 가능한 이유 : 추상 클래스는 객체 생성 후 사용할 수 있으므로 호출 메서드가 있어도 구현이 안되기 때문에 가능
        //그래서 호출하기 위해서는 자손 클래스를 만들어 객체 생성한 다음 호출하면 된다.
    }
}

class AudioPlayer extends player {
    void play(int pos) {
        System.out.println("추상 클래스의 play메서드 오버라이딩" + pos); //몸통 만들기 : 구현
    }

    void stop() {
        System.out.println("추상 클래스의 stop메서드 오버라이딩"); //몸통 만들기 : 구현
    }
}

abstract class AudioPlayer2 extends player {
    void play(int pos) { // 추상 메서드 구현을 전체 다 하지 않을 경우 class의 제어자에 abstract를 붙여야 함
        System.out.println("추상 클래스의 play메서드 오버라이딩"); //몸통 만들기 : 구현
    }
}

public class abstractClass { //추상 메서드
    public static void main(String[] args) {
        // player p = new player(); //에러 추상 클래스의 인스턴스는 생성 불가
        AudioPlayer ap = new AudioPlayer(); //추상클래스의 객체는 만들 수 없지만 자손 클래스를 통해 생성 가능함
        player ap2 = new AudioPlayer(); // 사용 가능 (다형성)
        ap.play(1);
        ap.stop();
    }
}