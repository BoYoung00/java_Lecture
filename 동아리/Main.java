package 동아리;

public class Main {
    public static void main(String[] args) {
        Shopping shopping = new Shopping();

        while (true) {
            int select = shopping.shoppingMenu();

            if (select == 1) {
                Cart cart = shopping.rentCart();
                while (true) {
                    int select2 = shopping.carMenu();

                    if (select2 == 5) {
                        break;
                    }

                    shopping.cartAction(cart, select2);
                }
            } else if (select == 2) {
                shopping.returnCart();
            } else if (select == 3) {
                break;
            }
        }
    }
}
