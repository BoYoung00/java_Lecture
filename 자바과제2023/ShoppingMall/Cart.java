package 자바과제2023.ShoppingMall;

import java.util.LinkedList;

class Cart {
    private String user; //카트 소유자
    private LinkedList<Item> items = new LinkedList<>(); //카드에 저장된 아이템


    public Cart(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    // 장바구니 아이템 추가
    public void addCart(String name, int price, int count) {
        for (Item item : items) {
            if (item.getProductName().equals(name)) {
                item.setCount(item.getCount() + count);
                return;
            }
        }
        items.add(new Item(name, count, price));
    }

    // 장바구니 아이템 제거
    public void removeCart(String name) {
        for (Item item : items) {
            if (item.getProductName().equals(name)) {
                items.remove(item);
                return;
            }
        }
        System.out.println("일치하는 아이템이 없습니다.");
    }

    // 장바구니 아이템 수량 변경
    public void updateCart(String name, int count) {
        for (Item item : items) {
            if (item.getProductName().equals(name)) {
                item.setCount(count);
                return;
            }
        }
        System.out.println("일치하는 아이템이 없습니다.");
    }

    // 장바구니 비우기
    public void emptyCart() {
        items.clear();
    }

    // 장바구니 아이템 출력
    public void printItems() {
        System.out.println("-----------------------");
        if (items.isEmpty()) {
            System.out.println("상품이 존재하지 않습니다.");
        }
        int index = 0;
        for (Item item : items) {
            index++;
            System.out.println("<"+index+"번 상품>");
            System.out.println("상품 이름 : " + item.getProductName());
            System.out.println("상품 가격 : " + item.getPrice());
            System.out.println("상품 수량 : " + item.getCount());
        }
    }

}
