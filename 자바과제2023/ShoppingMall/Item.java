package 자바과제2023.ShoppingMall;

public class Item {
    private String productName; //제품명
    private int count; //수량
    private int price; //가격

    public Item(String productName, int quantity, int price) {
        this.productName = productName;
        this.count = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
