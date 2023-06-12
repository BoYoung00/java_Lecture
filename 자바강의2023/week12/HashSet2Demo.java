package 자바강의2023.week12;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Fruit {
	String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fruit)
			return ((Fruit) obj).name.equals(name);
		return false;
	}
	
}

public class HashSet2Demo {
	public static void main(String[] args) {
		Set<Fruit> f = new HashSet<>();
		f.add(new Fruit("사과"));
		f.add(new Fruit("사과"));
		System.out.println(f.size());
		System.out.println(f);

	}
}
