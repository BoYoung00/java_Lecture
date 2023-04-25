package 자바강의2023.week7;


import java.util.Objects;

class Mouse {
	String name;

	public Mouse(String name) {
		super();
		this.name = name;
	}
	
}

class Keyboard {
	String name;

	public Keyboard(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Keybord [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Keyboard) {
			Keyboard k = (Keyboard) obj;
			if (name.equals(k.name))
				return true;
		}
		return false;
	}
	
}
