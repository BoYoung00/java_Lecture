package 자바강의2023.week7;


public class StringBuilderDemo {
	public static void main(String[] args) {
		String s = new String("hi");
		
		System.out.println(s.hashCode() + " : " + s);
		s = s + "!";
		System.out.println(s.hashCode() + " : " + s);
		
		StringBuilder sb = new StringBuilder("hi");
		System.out.println(sb.hashCode() + " : " + sb);
		sb = sb.append("!");
		System.out.println(sb.hashCode() + " : " + sb.toString());
		
		System.out.println(sb.replace(0, 2, "Good bye").insert(0, "Java, "));
	}
}
