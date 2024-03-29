package 자바강의2023.week9;

public abstract class StdInfoDTO {
	protected StdInfo stdInfo[];
	protected int stdNum;
	
	public StdInfoDTO(int stdNum) {
		super();
		this.stdNum = stdNum;
		this.stdInfo = new StdInfo[stdNum];
	}
	
	public void printInfo(String name) {
		int index;
		boolean flag=false;
		
		for (int i = 0; i < stdInfo.length; i++) {
			index=stdInfo[i].getName().indexOf(name);
			if(index <0)
				continue;
			System.out.println("["+(i+1)+"]name : " + stdInfo[i].getName()+", number : "+stdInfo[i].getNumber());
			System.out.println(stdInfo[i].getScore());
			System.out.println("=======================================");
			flag=true;
		}
		if(flag == false)
			System.out.println("검색된 결과가 없음");
	}
	
	public abstract void inputStdInfo();
}
