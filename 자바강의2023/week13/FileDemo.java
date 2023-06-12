package 자바강의2023.week13;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("C:\\Windows");
		File[] fs = file.listFiles(); 
		String name = null;
		GregorianCalendar cal = new GregorianCalendar(); //파일을 날짜출력
		
		for(File f : fs) {
			name = f.getName(); //파일이름
			long time = f.lastModified(); 
			cal.setTimeInMillis(time);
			if (f.isDirectory())
				System.out.printf("%-15s <DIR>[%d년%d월%d일]%n", name, cal.get(Calendar.YEAR),
						Calendar.MONTH+1, cal.get(Calendar.DAY_OF_MONTH));
			else 
				System.out.printf("%-15s <%7d>[%d년%d월%d일]%n", name, f.length(), cal.get(Calendar.YEAR),
						Calendar.MONTH+1, cal.get(Calendar.DAY_OF_MONTH));
		}
	}

}
