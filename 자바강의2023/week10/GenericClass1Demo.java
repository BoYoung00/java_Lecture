package 자바강의2023.week10;

public class GenericClass1Demo {

	public static void main(String[] args) {
		ObjCup c = new ObjCup();
		
		c.setBeverage(new Beer());
		Beer b1 = (Beer) c.getBeverage();
		
		c.setBeverage(new Boricha());
		
		b1 = (Beer) c.getBeverage(); //실행시 오류
		// Boricha 객체를 Beer 타입으로 변환함으로서 오류 발생
	}

}
