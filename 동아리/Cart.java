package 동아리;

import java.util.LinkedList;

public class Cart {
    String user;
    LinkedList<Item> items = new LinkedList<Item>();



    public Cart(String user) { //객체생성 도와주는 거
        this.user = user;
    }

    public String getUser() { //필드값 반환
        return user;
    }

    public void addCart(String name, int price, int count) {
        for (Item item : items) {
            if (item.getName().equals(items)) {
                item.setCount(item.getCount() + count);
                return;
            }
        }
        items.add(new Item(name, price, count));
    }

    public void updateCart(String name, int count) {
        for (Item item : items) {
            if (item.getName().equals(items)) {
                item.setCount(count);
            }
        }
    }

    public void printItems() {
        System.out.println("------------------");
        if (items.isEmpty()) {
            System.out.println("상품이 존재하지 않습니다.");
        }
        for (Item item : items) {
            System.out.println("상품 이름 : " + item.getName());
            System.out.println("상품 가격 : " + item.getPrice());
            System.out.println("상품 수량 : " + item.getCount());
        }
    }

    public void removeCart(String name) {
        System.out.println("------------------");
        if (items.isEmpty()) {
            System.out.println("상품이 존재하지 않습니다.");
        }
        for (Item item : items) {
            if (item.getName().equals(name)) {
                items.remove(item);
            }
        }
    }

    public void emptyCart() {
        items.clear();
    }
}
