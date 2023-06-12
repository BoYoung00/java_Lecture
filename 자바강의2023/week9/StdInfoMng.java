package 자바강의2023.week9;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StdInfoMng extends StdInfoDTO {
	private int subjectNum;
	private Scanner in = new Scanner(System.in);
	
	// 생성자를 명시하지 않을 경우 컴파일러에 의해 기본 생성자가 자동 생성
	// 자동 생성된 기본 생성자는 슈퍼클래스의 기본 생성자를 자동 호출
	// 슈퍼 클래스에는 기존 생성자가 없기 때문에 오류가 발생
	// 해결방법 1) 슈퍼 클래스에 기본 생성자를 생성
	// 해결방법 2) 서브 클래스에서 인자를 가지는 생성자를 정의해서 슈퍼클래스의 생성자를 자동 호출
	
	public StdInfoMng(int stdNum, int subjectNum) {
		super(stdNum);
		this.subjectNum = subjectNum;
	}
	
	@Override
	public void inputStdInfo() {
		String name;
		int number;
		StringBuilder sb;
		int i=0;
		StdInfo m;
		
		while (i < stdNum) {
			System.out.println("["+(i+1)+"]name : ");
			name = in.nextLine();
			System.out.println("["+(i+1)+"]number : ");
			number = in.nextInt();
			in.nextLine();
			m = new StdInfo(name, number);
			
			if(this.equals(m)!=true)
				continue;
			super.stdInfo[i]=m;
			sb=new StringBuilder();
			
			for (int j = 0; j < subjectNum; j++) {
				System.out.println("subject["+(j+1)+"] : ");
				sb = sb.append(in.nextLine());
				sb = sb.append("\\");
			}
			super.stdInfo[i].setScore(sb.toString());
			i++;
		}

	}

	@Override
	public boolean equals(Object obj) {
		StdInfo temp;
		if (obj instanceof StdInfo) {
			StdInfo m = (StdInfo)obj;
			for (int i = 0; i < stdInfo.length; i++) {
				temp = stdInfo[i];
				if (temp != null) {
					if (temp.getName().equals(m.getName()) && (temp.getNumber()==m.getNumber())) 
						return false;
				} //if
			} //for
			return true;
		} //if
		return false;
	}
	
	public void printInfo(int scorePos, int limit) {
		StringTokenizer st;
		int score;
		boolean flag = false;
		for (int i = 0; i < stdInfo.length; i++) {
			st = new StringTokenizer(stdInfo[i].getScore(), "\\");
			for (int j = 0; st.hasMoreTokens(); j++) {
				score = Integer.parseInt(st.nextToken());
				if ((scorePos != j) || (score <limit)) 
					continue;
				System.out.println("["+(i+1)+"]name : " + stdInfo[i].getName()+", 학번 : "+ stdInfo[i].getNumber());
				System.out.println(stdInfo[i].getScore());
				System.out.println("=================================");
				flag=true;
			} //for
		} //for
		if (flag ==false) 
			System.out.println("검색 결과가 없음");	
	}
	
	public static void main(String[] args) {
		StdInfoMng m = new StdInfoMng(2, 3);
		m.inputStdInfo();
		m.printInfo(1,40);

	}
}
