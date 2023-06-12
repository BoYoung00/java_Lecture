package 자바강의2023.week12.File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class BufferedStreamDemo {
	public static void main(String[] args) {
		long start, end, duration;
		String org = "c:\\Program Files (x86)\\Internet Explorer\\iexplore.exe";
		String dst = "c:\\Temp\\iexplore1.exe";
		
		start = System.nanoTime();
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(org));
			 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dst));){
			while (bis.available() > 0) { //읽을 수 있는 바이트 수
				int b = bis.read();
				bos.write(b);
				
			}
			bos.flush();
		} catch (IOException e) {}
		
		end = System.nanoTime();
		duration = end - start;
		System.out.println("버퍼를 사용한 경우 : " + duration);
		
		start = System.nanoTime();
		try (FileInputStream fis = new FileInputStream(org);
			 FileOutputStream fos = new FileOutputStream(dst)){
			while(fis.available() > 0) {
				int b = fis.read();
				fos.write(b);
			}
			fos.flush();
		} catch (IOException e) {}
		end = System.nanoTime();
		duration = end - start;
		System.out.println("버퍼를 사용하지 않은 경우 : " + duration);
		
	}
}
