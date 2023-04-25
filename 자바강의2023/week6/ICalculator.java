package 자바강의2023.week6;

public interface ICalculator {
	String PLUS = "plus", Minus="minus", Multiple="multiple";
	
	public int plus(int i, int j);
	
	public int minus(int i, int j);
	
	default int multiple(int i, int j) {
		return i * j;
	}
	
	public static int exec(String opt, int i, int j) {
		initMessage(opt);
		CalculatorImpl cal = new CalculatorImpl();
		int retVal=0;
		switch (opt) {
		case "plus":
			retVal=cal.plus(i,j);
			break;
		case "minus":
			retVal=cal.minus(i,j);
			break;
		case "multiple":
			retVal=cal.multiple(i,j);
			break;
		}
		return retVal;
	}
	
	private static void initMessage(String opt) {
		System.out.println(opt + "입니다~~");
	}
	
}

