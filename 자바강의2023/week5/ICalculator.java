package 자바강의2023.week5;

public interface ICalculator {
	// 인터페이스는 상수, 추상메서드, 특수메서드만 가질 수 있다.
	
	String PLUS = "plus", Minus = "minus", Multiple="multiple";
	int plus(int i, int j);
	int minus(int i, int j);
}