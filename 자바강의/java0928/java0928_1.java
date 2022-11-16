package 자바강의.java0928;

public class java0928_1 {
    public static void main(String[] args) {

        for (int i=1; i <=9; i++) {
            System.out.printf("7 * %d = %d\n", i, 7*i);
        }

        System.out.println("");
        for (int i=2; i<=9; i++) {
            for (int j=1; j<=9; j++) {
                System.out.printf("%d * %d = %d\n", i, j, i*j);
            }
            System.out.println("");
        }

        int i;
        int j;


        for (i=1; i<=9; i++) {
            for (j=2; j<=9; j++) {
                System.out.printf("%d * %d = %d\t", j, i, i*j);
            }
            System.out.println("");
        }


        System.out.println("");
        for (i=2; i<=6; i=i+4) {
            for (j=1; j<=9; j++) {
                for (int c=i; c<i+4; c++) {
                    System.out.printf("%d * %d = %d\t", c, j, j * c);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
}

