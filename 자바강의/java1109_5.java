package 자바강의;

public class java1109_5 {
    public static void main(String[] args) {
        if (args.length ==2) {
            int i = Integer.parseInt(args[1]);
            nPrintln(args[0], i);
        } else
            System.out.println("No parameter!");
    }
    public static void nPrintln(String s, int n) {
        for (int i = 0; i <n; i++)
            System.out.println(s);
    }
}
