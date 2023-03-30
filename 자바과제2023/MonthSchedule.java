package 자바과제2023;

import java.util.Scanner;

class Day {
    Scanner in = new Scanner(System.in);
    private String scaheduleArr[] = new String[31]; //스케줄 모음용 배열
    int day; //스케줄 입력할 일자

    public void setScaheduleArr(int num, String str) { this.scaheduleArr[num] = str; }
    public String getScaheduleArr(int num) { return scaheduleArr[num]; }

    public void setDay(int day) { this.day = day; }
    public int getDay() { return day; }

    //추가할 일자 받기
    public void addInquiryDay() {
        System.out.print("추가할 스케줄 일자를 입력해주세요 (1 ~ 31): ");
        int addDay = in.nextInt();

        if (addDay <= 31 && addDay >= 1) {
            in.nextLine();
            setDay(addDay);
            addScahedule();
        } else {
            System.out.println("1~31 사이를 입력해주세요.");
            System.out.println("------------------------------------------------");
            addInquiryDay();
        }
    }
    //추가
    public void addScahedule() {
        System.out.print("스케줄 내용을 입력해주세요. : ");
        String content = in.nextLine();

        if (!content.equals("")) {
            scaheduleArr[getDay()-1] = content;
            System.out.println("추가가 완료되었습니다.");
        } else {
            System.out.println("아무 내용이 없습니다. 다시 작성해주세요.");
            System.out.println("------------------------------------------------");
            addScahedule();
        }

    }
    //삭제
    public void deleteScahedule() {
        System.out.print("삭제할 스케줄 일자를 작성해주세요 (1 ~ 31) : ");
        int deleteday = in.nextInt();

        if (deleteday <= 31 && deleteday >= 1) {
            if (scaheduleArr[deleteday-1] != null) {
                setScaheduleArr(deleteday-1, null);
                System.out.println("삭제가 완료되었습니다.");
            } else {
                System.out.println("삭제할 스케줄이 없습니다.");
            }
        } else {
            System.out.println("1~31 사이를 입력해주세요.");
            System.out.println("------------------------------------------------");
            deleteScahedule();
        }
    }
    //검색
    public void searchScahedule() {
        System.out.print("검색할 일자를 입력해주세요 (1 ~ 31) : ");
        int searchDay = in.nextInt();

        if (searchDay <= 31 && searchDay >= 1) {
            if (getScaheduleArr(searchDay-1)!=null) {
                System.out.println(getScaheduleArr(searchDay-1));
            } else {
                System.out.println("저장되어 있는 스케줄이 없습니다.");
            }
        } else {
            System.out.println("1~31 사이를 입력해주세요.");
            System.out.println("------------------------------------------------");
            searchScahedule();
        }
    }
}

public class MonthSchedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Day user = new Day();

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.print("무엇을 하시겠습니까? (1. 추가 / 2. 삭제 / 3. 검색 / 0. 종료) : ");
            int query = in.nextInt();
            if (query == 0) { //종료
                break;
            } else if (query == 1) {  //추가
                user.addInquiryDay();
            } else if (query == 2) { //삭제
                user.deleteScahedule();
            } else if (query == 3) { //검색
                user.searchScahedule();
            } else { //오류
                System.out.println("0~3 사이로 작성해주세요.");
            }
        }
    }
}
