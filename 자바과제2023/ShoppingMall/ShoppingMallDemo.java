package 자바과제2023.ShoppingMall;

public class ShoppingMallDemo {
    public static void main(String[] args) {
        Shopping sh = new Shopping();

        while (true) {
            int selete = sh.shoppingMenu();

            if (selete == 3) {
                break;
            } else if (selete == 2) {
                sh.returnCart();
            } else {
                Cart cart = sh.rentCart();

                while (true) {
                    int cartSel = sh.cartMenu();
                    if (cartSel == 5)
                        break;
                    sh.cartAction(cart, cartSel);
                }
            }
        }
    }
}
