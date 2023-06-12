package 자바강의2023.중간시험_정답;

public abstract class StdInfoDTO {
    protected StdInfo stdInfo[];
    protected int stdNum;
    public StdInfoDTO(int stdNum) {
        super();
        this.stdNum = stdNum;
        this.stdInfo = new StdInfo[stdNum];
    }
    public abstract void inputStdInfo();
    public void printInfo(String name) {
        int index; //동일한 문자열의 인덱스
        boolean flag=false; // "검색된 결과가 없음" 메시지를 출력 플래그
        for(int i=0; i<stdInfo.length ; i++) {
            index = stdInfo[i].getName().indexOf(name);
            if(index <0)
                continue;
            System.out.println("[" + (i+1) + "]name : "
                    + stdInfo[i].getName() + ", number : " + stdInfo[i].getNumber());
            System.out.println(stdInfo[i].getScore());
            System.out.println("==========================");
            flag=true;
        }
        if(flag == false)
            System.out.println("검색된 결과가 없음");
    }
}