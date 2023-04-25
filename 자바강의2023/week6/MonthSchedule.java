package 자바강의2023.week6;

import java.util.Scanner;

class Day {
	private String work;

	public Day(String work) {
		super();
		this.work = work;
	}

	public void setWork(String work) {
		this.work = this.work + "\\" + work;
	}
	
	public void show() {
		int index;
		String str = this.work;
		for (int i = 0;; i++) {
			index = str.indexOf("\\");
			if (index ==-1) {
				System.out.println("["+i+"]"+str);
				return;
			}
			System.out.println("["+i+"]"+str.substring(0, index));
			str = str.substring(index+1);
		}
	}
}

public class MonthSchedule {
	private int nDays;
	private Day [] days;
	private Scanner scanner;
	
	public MonthSchedule(int nDays) {
		super();
		this.nDays = nDays;
		this.days = new Day[nDays];
		scanner = new Scanner(System.in);
	}

	private int inputDay() {
		System.out.println("날짜(1~30) : ");
		int day = scanner.nextInt();
		scanner.nextLine();
		
		day--;
		if (day < 0 || day > nDays) {
			System.out.println("날짜 잘못 입력하였습니다!");
			return -1;
		}
		return day;
	}

	public static void main(String[] args) {
		

	}

}
