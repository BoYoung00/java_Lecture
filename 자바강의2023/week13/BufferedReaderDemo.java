package 자바강의2023.week13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Temp\\org.txt"));){
			 br.lines().forEach(s -> System.out.println(s)); //lines 파일 라인으로 읽기

//			String a;
//			a = br.readLine();
//			System.out.println(a);
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
