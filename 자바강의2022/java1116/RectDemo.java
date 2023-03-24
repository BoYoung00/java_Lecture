package 자바강의2022.java1116;

class MyRectangle {
    double x, y;

    double getArea() {
        return x * y;
    }

    boolean isSquare() {
        if (x == y) return true;
        else return false;
    }
}

public class RectDemo {
    public static void main(String[] args) {
        MyRectangle rect = new MyRectangle();
        rect.x = 5;
        rect.y = 5;

        System.out.println("사각형의 면적은 " + rect.getArea());
        if (rect.isSquare() == true)
            System.out.println("정사각형입니다.");
        else
            System.out.println("정사각형이 아닙니다");
    }
}
