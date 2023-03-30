package 자바과제2023;

import java.util.Scanner;

class Dictionary {
    Scanner in = new Scanner(System.in);
    String words[][] = {{"빨강","red"}, {"주황","orange"}, {"노랑","yellow"}, {"초록","green"}, {"파랑","blue"}, {"보라", "purple"}};
    String color; //입력받은 단어

    public String[][] getWords() {
        return words;
    }
    public String getColor() {
        return color;
    }

    public String SearchWords() { //검색
        System.out.print("검색할 색깔 : ");
        color = in.next();

        for (int i=0; i < words.length; i++) {
            for (int j=0; j < words[i].length; j++) {
                if (words[i][0].equals(color)) {
                    return words[i][1];
                }
            }
        }
        return "";
    }
}

public class DicApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dictionary search = new Dictionary();

        while (true) {
            System.out.println("------------------------------------------------");
            System.out.print("단어 검색 프로그램 (1. 검색 / 0. 종료) : ");
            int query = in.nextInt();

            if (query == 0) { //종료
                break;
            } else if (query == 1) {  //저장
                String word = search.SearchWords();
                if (word.equals("")) {
                    System.out.println("단어가 없습니다.");
                } else {
                    System.out.println("'"+search.getColor() + "'의 번역결과는 '" + word + "'입니다.");
                }
            } else { //오류
                System.out.println("0~1 사이로 작성해주세요.");
            }
        }

    }
}
