package 자바과제2023;

import java.util.Calendar;

public class CalendarNow {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        String[] apArr = {"오전", "오후"};
        String[] daArr = {"일", "월", "화", "수", "목", "금", "토"};

        int yy = cal.get(Calendar.YEAR); // 년도
        int mm = cal.get(Calendar.MARCH) + 1; // 월
        int dd = cal.get(Calendar.DAY_OF_MONTH); // 일
        int da = cal.get(Calendar.DAY_OF_WEEK); // 요일
        int ampm = cal.get(Calendar.AM_PM); // 오전 오후
        int hh = cal.get(Calendar.HOUR); // 시간
        int mi = cal.get(Calendar.MINUTE); // 분
        int ss = cal.get(Calendar.SECOND); // 초

        System.out.printf("%04d년 %02d월 %02d일 \n", yy, mm, dd);
        System.out.println(daArr[da] + "요일 " + apArr[ampm]);
        System.out.printf("%02d시 %02d분 %02d초", hh, mi, ss);

    }
}
