package 자바강의.java1123;

class Pet {
    private String type;
    private int age;

    public Pet(String type, int age) {
        this.type = type;
        this.age = age;
    }

    public Pet(String type) {
        this.type = type;
        this.age = 5;
    }

    public Pet(int age) {
        this.type = "병아리";
        this.age = age;
    }
    public Pet() {
        this.type = "병아리";
        this.age = 5;
    }
    
    public String getType() {
        return type;
    }
    public int getAge() {
        return age;
    }
    
    public void setType(String t) {
        type = t;
    }
    public void setAge(int a) {
        age = a;
    }

    public void move() {
        System.out.printf("%s가 움직입니다.\n", type);
    }
    public void displayAge() {
        System.out.printf("%s는 %d개월입니다.\n", type, age);
    }
}

public class PetDemo {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setType("치와와");
        pet.setAge(2);
        pet.move();
        pet.displayAge();

        Pet pet1 = new Pet("호랑이");
        pet1.move();
        pet1.displayAge();
    }

}
