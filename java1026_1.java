import java.util.Scanner;

public class java1026_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("단 수 : ");
        int dan = in.nextInt();
        if (dan<=9 && dan>=1)
            gugudan(dan);
        else
            System.out.printf("1~9사이로 작성해주세요");
    }
    public static void gugudan(int dan){
        for (int i = 1; i<=9; i++){
            System.out.printf("%d * %d = %d\n", dan, i, dan*i);
        }
        System.out.println();
    }
}
