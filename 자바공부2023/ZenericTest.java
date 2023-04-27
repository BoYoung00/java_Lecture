package 자바공부2023;

import java.util.ArrayList;

class Fruit2 {public String toString() { return "Fruit";}}
class Apple2 extends Fruit2 {public String toString() { return "Apple";}}
class Grape2 extends Fruit2 {public String toString() { return "Grape";}}
class Toy {public String toString() { return "Toy";}}

class Juice {
    String name;

    Juice(String name) {this.name = name + "Juice";}
    public String toString() { return name;}
}

class Juicer {
    static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
        String tmp = "";

        for (Fruit2 f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}

public class ZenericTest {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
//        FruitBox2<Grape2> grapeBox = new FruitBox2<Apple2>(); //에러, 타입 불일치
//        FruitBox2<Toy> toyBox = new FruitBox2<Toy>(); //에러, Toy는 Fruit2를 상속받지 않았기 때문

        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());
//        appleBox.add(new Grape2()); //에러, Grape는 Apple의 자손이 아님

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));

        //예제2
        Box<String> b = new Box<String>();
//        b.add(new Integer(100)); //오류

        Box<String> bStr = null;

        b=(Box)bStr;    // 가능하나 경고
        bStr = (Box<String>) b; // 가능하나 경고
    }
}

class FruitBox2<T extends Fruit2> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {list.add(item);}
    T get(int i) {return list.get(i);}
    ArrayList<T> getList() { return list;}
    int size() { return list.size();}
    public String toString() { return list.toString();}
}

