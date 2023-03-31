package 자바과제2023;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Phone {
    private String name;
    private String number;

    public Phone(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SaveSearch {
    Scanner in = new Scanner(System.in);
    ArrayList<Phone> pages = new ArrayList<>();
    String name;

    public void inquiryName() { //이름 입력 받기 메소드
        System.out.print("이름 : ");
        String name = in.nextLine();

        if (name.isEmpty()) {
            System.out.println("아무 내용이 없습니다. 다시 작성해주세요.");
            System.out.println("------------------------------------------------");
            inquiryName();
        } else {
            this.name = name;
        }
    }

    public boolean numberValidation(String number) { //전화번호 입력 유효성검사
        return (Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", number));
    }

    public void addPhone() { //전화번호 추가 메서드
        System.out.print("전화번호 (010-xxxx-xxxx) : ");
        String number = in.nextLine();

        if (numberValidation(number)) {
            pages.add(new Phone(name, number));
            System.out.println("저장이 완료되었습니다.");
        } else {
            System.out.println("전화번호 양식이 틀렸습니다. 다시 작성해주세요.");
            addPhone();
        }
    }

    public void searchPhone() { //전화번호 검색 메서드
        int i=1;
        for (Phone phone : pages) {
            if(phone.getName().equals(name)) {
                System.out.println("<<검색 결과>>");
                System.out.println("이름 : " + phone.getName() + ",\t 전화번호 : " + phone.getNumber());
                break;
            } else if (pages.size() == i) {
                System.out.println("일치하는 이름이 없습니다.");
            }
            i++;
        }
    }
}

public class PhoneBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        SaveSearch phone = new SaveSearch();

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.print("전화번호부 프로그램 (1. 저장 / 2. 검색 / 0. 종료): ");
            int query = in.nextInt();

            if (query == 0) { //종료
                break;
            } else if (query == 1) {  //저장
                System.out.println("<<전화번호 저장>>");
                phone.inquiryName();
                phone.addPhone();
            } else if (query == 2) { //검색
                System.out.println("<<전화번호 검색>>");
                phone.inquiryName();
                phone.searchPhone();
            } else { //오류
                System.out.println("0~2 사이로 작성해주세요.");
            }
        }
    }
}
