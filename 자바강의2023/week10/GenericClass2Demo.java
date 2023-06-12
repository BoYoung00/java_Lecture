package 자바강의2023.week10;

public class GenericClass2Demo {
	public static void main(String[] args) {
		GenericCup<Beer> c = new GenericCup<>();
		
		c.setBeverage(new Beer());
		Beer b1 = c.getBeverage();
		
		//Beer타입의 GenericCup 객체에 Boricha 객체를 담을 수 없음
		//컴파일 오류 발생
//		c.setBeverage(new Boricha());
		b1 = c.getBeverage();
	}
}
