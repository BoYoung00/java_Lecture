package 동아리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        LinkedList<String> Carts = new LinkedList<>();
        //제네릭 태그

        Shopping shopping = new Shopping();
        int select = shopping.shoppingMenu();

        while (true) {
            if (select == 1){
                String name = shopping.rentCart();
                System.out.println(name);
            }
            else if (select == 2) {

            }
        }
    }
    public int shoppingMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("------------------");
        System.out.println("1. 카트 임대");
        System.out.println("2. 카트 반납");
        System.out.println("3. 카트 종료");
        System.out.printf("동작 입력 : ");
        int select = in.nextInt();

        return select;
    }

    public String rentCart() {
        Scanner in = new Scanner(System.in);

        System.out.println("------------------");
        System.out.printf("카트 소유자 이름 입력 : ");
        String name = in.nextLine();

        return name;
    }

    public void returnCart(){
        Scanner in = new Scanner(System.in);

        System.out.println("------------------");
        System.out.printf("반납할 카드 소유자 이름 입력 : ");
        String name = in.nextLine();

    }

}
