package 자바강의2023.week9;

public class StdInfo {
	private String name;
	private int number;
	private String score;
	
	
	
	public StdInfo(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	
}
