public class java1102_1 {
    public static void main(String[] args) {
        String str = "  홍 길동    AB   CD   123  45";
        String result = "";

        for (int i = 0; str.length() > i; i++){
            if (str.charAt(i) != ' ') {
                result += str.charAt(i);
            }
        }

        System.out.println("처리전 \t ==> "+ str);
        System.out.println("처리후 \t ==> "+ result);
    }
}
