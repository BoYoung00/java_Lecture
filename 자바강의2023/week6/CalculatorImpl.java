package 자바강의2023.week6;

import java.lang.reflect.Executable;

public class CalculatorImpl implements ICalculator {
	@Override
	public int plus(int i, int j) {
		return i+j;
	}

	@Override
	public int minus(int i, int j) {
		return i-j;
	}
	
	public int multiple(int i, int j) {
		return (i * j)+5;
	}
	
	public static void main(String[] args) {
		System.out.println(ICalculator.exec(ICalculator.Multiple,2,5));
	}
}
