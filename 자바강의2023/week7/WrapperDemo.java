package 자바강의2023.week7;


public class WrapperDemo {
	public static void main(String[] args) {
		Integer bi1 = new Integer(10);
		
		System.out.println(bi1.intValue());
		System.out.println(bi1.doubleValue());
		
		Integer bi2 = 20; //자동 박싱
		int i2 = bi2 + 20; //자동 언박싱
		
		String s1 = Double.toString(3.14);
		
		Float pi = Float.parseFloat("3.14");
		
		Integer bi3 = Integer.valueOf("11", 16);
		
		System.out.println(bi3);
	}
}
