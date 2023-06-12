package 자바강의2023.week10;

import java.util.Scanner;

public class TrowsDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TrowsDemo td = new TrowsDemo();
		try {
			td.square(in.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("정수가 아닙니다.");
		}
	}
	private void square(String s) throws NumberFormatException {
		int n = Integer.parseInt(s);
		System.out.println(n * n);
	}

}
