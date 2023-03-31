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
        int inDay = Integer.parseInt(in.nextLine());

        if (inDay <= 31 && inDay >= 1) { // 31일 중에 하나를 입력 받음
            setDay(inDay); // day 값 할당하기
        } else {
            System.out.println("1~31 사이를 입력해주세요.");
            inquiryDay(); // 다시 돌아가기
        }
    }

    public int addScaheduleOverlap() { // 추가 일자 중복 확인
        int count = 1; // 두 if문이 다 해당이 안될 경우 1(yes)을 반환하기 위해 초기화
        while (true) {
            if (getScaheduleArr(getDay()) != null) { // 해당 날짜에 값이 있다면 제어
                System.out.print("이미 스케줄이 존재합니다. 덮어 씌우시겠습니까? (1. yes / 0. no) : ");
                count = Integer.parseInt(in.nextLine());
                if (count > 1 || count < 0) { // 1 또는 0 값을 받지 못 했을 때 제어
                    System.out.println("1 또는 0을 작성해주세요.");
                    System.out.println("------------------------------------------------");
                    continue;
                }
            } break;
        }
        return count;
    }

    public void addScahedule() { //추가
        System.out.print("스케줄 내용을 입력해주세요. : ");
        String content = in.nextLine();

        if (content.isEmpty()) { //nextLine에 아무 내용을 받지 않으면
            System.out.println("아무 내용이 없습니다. 다시 작성해주세요.");
            System.out.println("------------------------------------------------");
            addScahedule(); //다시 돌아가기
        } else {
            setScaheduleArr(getDay(), content); //배열에 추가해주기
            System.out.println("추가가 완료되었습니다.");
        }

    }

    public void deleteScahedule() { //삭제
        if (getScaheduleArr(getDay()) != null) { //검색한 날짜에 값이 있으면
            setScaheduleArr(getDay(), null); //삭제해주기
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("삭제할 스케줄이 없습니다.");
        }

    }

    public void searchScahedule() { //검색
        if (getScaheduleArr(getDay())!=null) { //검색한 날짜에 값이 있으면
            System.out.print("스케줄 내용 : ");
            System.out.println(getScaheduleArr(getDay())); //스케줄 내용을 가져와 보여주기
        } else {
            System.out.println("저장되어 있는 스케줄이 없습니다.");
        }

    }
}

public class MonthSchedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Day user = new Day();

        while (true) { //메인
            System.out.println("------------------------------------------------");
            System.out.print("스케줄 관리 프로그램 (1. 추가 / 2. 삭제 / 3. 검색 / 0. 종료) : ");
            int query = in.nextInt();

            if (query == 0) { break; } //종료

            else if (query == 1) {  //추가
                System.out.println("<<추가>>");
                user.inquiryDay(); //일자 받기
                int overlapcount = user.addScaheduleOverlap(); //스케줄 일자 중복제어
                if (overlapcount == 1) {
                    user.addScahedule();
                }
            }
            else if (query == 2) { //삭제
                System.out.println("<<삭제>>");
                user.inquiryDay(); //일자 받기
                user.deleteScahedule();
            }
            else if (query == 3) { //검색
                System.out.println("<<검색>>");
                user.inquiryDay(); //일자 받기
                user.searchScahedule();
            }
            else { //오류제어
                System.out.println("0~3 사이로 작성해주세요.");
            }
        }
        in.close();
    }
}
