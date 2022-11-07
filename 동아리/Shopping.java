package 동아리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Shopping {
    Scanner scan = new Scanner(System.in);

    LinkedList<Cart> Carts = new LinkedList<Cart>();
    //제네릭 태그

    public LinkedList<Cart> getCarts() {
        return Carts;
    }
    public int shoppingMenu() {
        System.out.println("------------------");
        System.out.println("1. 카트 임대");
        System.out.println("2. 카트 반납");
        System.out.println("3. 카트 종료");
        System.out.printf("동작 입력 : ");
        int select = scan.nextInt();

        return select;
    }

    public Cart rentCart() {

        System.out.println("------------------");
        System.out.print("임대할 소유자 이름 입력 : ");
        String name = scan.next();

        for (Cart cart : Carts) {
            if (cart.getUser().equals(name)) {
                return cart;
            }
        }
        Cart cart = new Cart(name);
        Carts.add(cart);
        return cart;
    }

    public void returnCart(){
        System.out.println("------------------");
        System.out.printf("반납할 카드 소유자 이름 입력 : ");
        String name = scan.next();

        for (Cart cart : Carts) {
            if (cart.getUser().equals(name)) {
                Carts.remove(name);
                break;
            }
        }
    }

    public int carMenu() {
        System.out.println("------------------");
        System.out.println("1. 카트에 상품 추가");
        System.out.println("2. 카트에 수량 추가");
        System.out.println("3. 카트 상품 제거");
        System.out.println("4. 카트 상품 출력");
        System.out.println("5. 카트 관련 동작 종료");
        System.out.printf("키트 동작 입력 : ");
        int select = scan.nextInt();

        return select;
    }

    public void cartAction(Cart cart, int select) {
        if (select == 1) {
            System.out.println("------------------");
            System.out.print("추가할 상품 이름 : ");
            String name = scan.next();
            System.out.print("추가할 상품 가격 : ");
            int price = scan.nextInt();
            System.out.print("추가할 상품 수량 : ");
            int count = scan.nextInt();

            cart.addCart(name, price, count);
        } else if (select == 2) {
            System.out.println("------------------");
            System.out.print("추가할 상품 이름 : ");
            String name = scan.next();
            System.out.print("추가할 상품 수량 : ");
            int count = scan.nextInt();

            cart.updateCart(name, count);
        } else if (select == 3) {
            System.out.println("--------------------\n제거할 상품 정보 입력(전부 : all)");
            System.out.print("상품 이름 : ");
            String itemName = scan.next();
            if (itemName.equals("all")){
                cart.emptyCart();
                return;
            }
            cart.removeCart(itemName);
        }
        else if (select == 4) {
            cart.printItems();
        }
    }

}
