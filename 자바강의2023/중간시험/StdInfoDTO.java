package 자바강의2023.중간시험;

import java.util.Scanner;

abstract class StdInfoDTO {
    protected StdInfo stdInfo[];
    protected int stdNum; //학생 수

    Scanner in = new Scanner(System.in);
    public StdInfoDTO(int stdNum) {
        this.stdNum = stdNum;
        stdInfo = new StdInfo[stdNum];
    }

    //입력받은 이름으로 학번, 이름 과목별 점수 출력
    public void printInfo() { //학생 검색
        System.out.print("검색할 학생의 이름 : ");
        String name;
        name = in.next();

        while (true) {
            int i = stdInfo.length;

            if (stdInfo.equals(name)) {
                System.out.println(stdInfo[i]);
                break;
            }
            if (i == stdInfo.length) {
                System.out.println("학생이 존재하지 않습니다.");
            }
        } //while
    }

    abstract void inputStdInfo(int stdnum); //추가
}


