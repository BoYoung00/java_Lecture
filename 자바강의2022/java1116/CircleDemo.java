package 자바강의2022.java1116;

public class CircleDemo {
    public static void main(String[] args) {
        double area;
        Circle myCircle = new Circle();

        myCircle.radius = 10.0;

        area = myCircle.findArea();

        myCircle.show(myCircle.radius, area);
    }
}

class Circle {
    double radius;

    double findArea() {
        return 3.14 * radius * radius;
    }

    void show(double x, double y) {
        System.out.printf("반지름 = %.1f, 넓이 = %.1f\n", x, y);
    }
}
