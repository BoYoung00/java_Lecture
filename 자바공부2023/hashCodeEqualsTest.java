package 자바공부2023;

import java.util.HashSet;
import java.util.Objects;

public class hashCodeEqualsTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("Bo", 24)); //equals와 hashCode 오버라이딩으로 중복으로 간주 됨
        set.add(new Person("Bo", 24));

        System.out.println(set);
    }
}

class Person {
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) return false;

        Person p = (Person) o;
        return this.age == p.age && this.name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name +":"+age;
    }
}
