package 자바강의2023.week12.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
	public static void main(String[] args) {
		String input = "c:\\Temp\\org.txt";
		String output = "c:\\Temp\\dup.txt";
		
		try (FileInputStream fis = new FileInputStream(input); //가져오기
			 FileOutputStream fos = new FileOutputStream(output)){ //쓰기
			int c;
			
			while((c = fis.read()) != -1) // 다 읽으면 -1 반환
				fos.write(c);
		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println("복사 완료");
	}
}
