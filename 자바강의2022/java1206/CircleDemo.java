package 자바강의2022.java1206;

class Circle {
    int radius;
    Circle() {
        radius = 1;
    }
    Circle(int radius) {
        this.radius = radius;
    }
    void show() {
        System.out.printf("반지름 : %d\n", radius);
    }
}
class ColorCircle extends Circle {
    String color;
    ColorCircle() {
        super();
        this.color = "yellow";
    }
    ColorCircle(String s) {
        super();
        this.color = s;
    }
    ColorCircle(int n, String s) {
        super(n);
        this.color = s;
    }
    void show() {
        System.out.printf("반지름 : %d, 색상 : %s\n", radius, color);
    }
}
public class CircleDemo {
    public static void main(String[] args) {
        ColorCircle c1 = new ColorCircle();
        c1.show();
        ColorCircle c2 = new ColorCircle("red");
        c2.show();
        ColorCircle c3 = new ColorCircle(5, "blue");
        c3.show();
    }
}
