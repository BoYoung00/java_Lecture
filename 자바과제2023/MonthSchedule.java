package 자바과제2023;

import java.util.Scanner;

class Day {
    Scanner in = new Scanner(System.in);
    private String scaheduleArr[] = new String[31]; //스케줄 모음용 배열
    int day; //선택일자 받기용

    public void setScaheduleArr(int num, String str) { this.scaheduleArr[num] = str; }
    public String getScaheduleArr(int num) { return scaheduleArr[num]; }

    public void setDay(int day) { this.day = day-1; }
    public int getDay() { return day; }

    public void inquiryDay() { //일자 입력 받기 메소드
        System.out.print("일자를 입력해주세요 (1 ~ 31) : ");
        int inDay = in.nextInt();

        if (inDay <= 31 && inDay >= 1) {
            in.nextLine();
            setDay(inDay);
        } else {
            System.out.println("1~31 사이를 입력해주세요.");
            inquiryDay();
        }
    }

    public void addScahedule() { //추가
        System.out.print("스케줄 내용을 입력해주세요. : ");
        String content = in.nextLine();

        if (content.isEmpty()) {
            System.out.println("아무 내용이 없습니다. 다시 작성해주세요.");
            System.out.println("------------------------------------------------");
            addScahedule();
        } else {
            setScaheduleArr(getDay(), content);
            System.out.println("추가가 완료되었습니다.");
        }

    }

    public void deleteScahedule() { //삭제
        if (getScaheduleArr(getDay()) != null) {
            setScaheduleArr(getDay(), null);
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제할 스케줄이 없습니다.");
        }

    }

    public void searchScahedule() { //검색
        if (getScaheduleArr(getDay())!=null) {
            System.out.print("스케줄 내용 : ");
            System.out.println(getScaheduleArr(getDay()));
        } else {
            System.out.println("저장되어 있는 스케줄이 없습니다.");
        }

    }
}

public class MonthSchedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Day user = new Day();

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.print("스케줄 관리 프로그램 (1. 추가 / 2. 삭제 / 3. 검색 / 0. 종료) : ");
            int query = in.nextInt();
            if (query == 0) { //종료
                break;
            } else if (query == 1) {  //추가
                System.out.println("<<추가>>");
                user.inquiryDay();
                user.addScahedule();
            } else if (query == 2) { //삭제
                System.out.println("<<삭제>>");
                user.inquiryDay();
                user.deleteScahedule();
            } else if (query == 3) { //검색
                System.out.println("<<검색>>");
                user.inquiryDay();
                user.searchScahedule();
            } else { //오류
                System.out.println("0~3 사이로 작성해주세요.");
            }
        }
    }
}
