package 자바강의.java1116;
class Phone {
    String model;
    int value;

    void print() {
        System.out.println(value + "만원 짜리 " + model + " 스마트폰");
    }
}

public class PhoneDemo {
    public static void main(String[] args) {
        Phone myphone = new Phone();

        myphone.model = "갤럭시 S8";
        myphone.value = 100;
        myphone.print();

        Phone yourphone = new Phone();

        yourphone.model = "G6";
        yourphone.value = 85;
        yourphone.print();
    }
}
