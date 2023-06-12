package 자바강의2023.중간시험;

import java.util.Scanner;

class StdInfoMng extends StdInfoDTO {
    int subjectNum; //과목 수

    public StdInfoMng(int stdNum, int subjectNum) {
        super(stdNum); //학생 수
        this.subjectNum = subjectNum; //과목 수
    }


    @Override
    public boolean equals(Object obj) { //동일한 성명, 학번 비교
        if (obj != null && obj instanceof StdInfo) {
            StdInfo s = (StdInfo) obj;
            StdInfo std = new StdInfo(s.getName(), s.getNumber());

            if (stdInfo.equals(std))
                return false;
        }
        return true;
    }

    @Override
    void inputStdInfo(int stdnum) { // 추가
        String name;
        int number;
        String score;

        System.out.println("---학생 추가---");
        System.out.print("성명 : ");
        name = in.next();

        System.out.print("학번 : ");
        number = in.nextInt();

        StdInfo equstd1 = new StdInfo(name, number);


        for (int i = 0; i < stdnum; i++) {
            if (stdInfo[i].equals(equstd1)) {
                stdInfo[i] = new StdInfo(name, number);

                System.out.print("과목 점수('\\'구분 문자를 이용) : ");
                score = in.next();
                stdInfo[i].setScore(score);
            }
        }
    }

    //입력받은 이름으로 학번, 이름 과목별 점수 출력
    public void printInfo() { //검색
        System.out.println("---일정 점수 이상인 학생 검색---");
        System.out.print("일정 점수 : ");
        int scor = in.nextInt();

        while (true) {
            int i = stdInfo.length;

            int intscor = Integer.parseInt(stdInfo[i].getScore());

            if (intscor >= scor) {
                System.out.println(stdInfo[i]);
                break;
            }
            if (i == stdInfo.length) {
                System.out.println("학생이 존재하지 않습니다.");
                continue;
            }
            i++;
        } //while
    }
}

class StdInfoDemo {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("<<학생정보 프로그램>>");
            System.out.print("학생 수 : ");
            int stdnum = in.nextInt();

            System.out.print("과목 수 : ");
            int subnum = in.nextInt();

            StdInfoMng std = new StdInfoMng(stdnum,subnum);

            for (int i = 0; i < stdnum; i++) {
                std.inputStdInfo(stdnum);

            }
            std.printInfo();

        }
    }
}
