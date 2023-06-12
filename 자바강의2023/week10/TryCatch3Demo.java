package 자바강의2023.week10;

public class TryCatch3Demo {
	public static void main(String[] args) {
		int[] arr = {0,2,3};
		try {
			int x= arr[3];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("원소가 존재하지 않습니다.");
		} catch (Exception e) {
			System.out.println("어이쿠!!!");
		}
		System.out.println("종료.");
	}
}
