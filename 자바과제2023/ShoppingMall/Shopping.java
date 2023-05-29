package 자바과제2023.ShoppingMall;

import java.util.LinkedList;
import java.util.Scanner;

public class Shopping {
    private Scanner in = new Scanner(System.in);
    private LinkedList<Cart> carts = new LinkedList<>();

    // 쇼핑 메뉴 출력
    public int shoppingMenu() {
        System.out.println("-----------------------");
        System.out.println("1. 카트 임대");
        System.out.println("2. 카트 반납");
        System.out.println("3. 쇼핑 종료");
        System.out.print("동작 입력 : ");
        int select = in.nextInt();
        return select;
    }

    // 카트 임대
    public Cart rentCart() {
        System.out.println("-----------------------");
        System.out.print("(임대) 사용자 이름 입력 : ");
        String name = in.next();

        for (Cart cart : carts) {
            if (cart.getUser().equals(name)) {
                return cart;
            }
        }
        Cart cart = new Cart(name);
        carts.add(cart);
        return cart;
    }

    // 카트 반납
    public void returnCart() {
        System.out.println("-----------------------");
        System.out.print("(반납) 사용자 이름 입력 : ");
        String name = in.next();

        for (Cart cart : carts) {
            if (cart.getUser().equals(name)) {
                carts.remove(cart);
                return;
            }
        }
        System.out.println("일치하는 이름이 없습니다.");
    }

    // 카트 메뉴 출력
    public int cartMenu() {
        System.out.println("-----------------------");
        System.out.println("1. 카트에 상품 추가");
        System.out.println("2. 카트에 수량 추가");
        System.out.println("3. 카트 상품 제거");
        System.out.println("4. 카트 상품 출력");
        System.out.println("5. 카트 관련 동작 종료");
        System.out.print("카트 동작 입력 : ");
        int select = in.nextInt();
        return select;
    }

    // 카트 메뉴 액션 (cartMenu 기능 구현)
    public void cartAction(Cart cart, int select) {
        if (select == 1) {
            System.out.println("-----------------------\n[상품 추가]");
            System.out.print("상품 이름 : ");
            String name = in.next();
            System.out.print("상품 가격 : ");
            int price = in.nextInt();
            System.out.print("상품 수량 : ");
            int count = in.nextInt();

            cart.addCart(name, price, count);
        } else if (select == 2) {
            System.out.println("-----------------------\n[수량 추가]");
            System.out.print("상품 이름 : ");
            String name = in.next();
            System.out.print("상품 수량 : ");
            int count = in.nextInt();

            cart.updateCart(name, count);
        } else if (select == 3) {
            System.out.println("-----------------------\n[상품 제거]");
            System.out.print("상품 이름 (모두 제거 : all) : ");
            String name = in.next();

            if (name.equals("all")) {
                cart.emptyCart();
                return;
            }
            cart.removeCart(name);
        } else if (select == 4) { // 상품 출력
            cart.printItems();
        }
    }
}
