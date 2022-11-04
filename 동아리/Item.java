package 동아리;

//담을 데이터 표본
public class Item {
        String name;
        int price;
        int count;

    public Item(String name, int price, int count) { //객체생성 도와주는 거
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
