import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入：");
        String s = in.nextLine();
        char[] s2char = s.toCharArray();
        int temp;
        for (int i = 0; i < s2char.length; i++) {
            for (int j = 0; j < s2char.length - i - 1; j++) {
                if (s2char[j] < s2char[j + 1]) {
                    temp = s2char[j + 1];
                    s2char[j + 1] = s2char[j];
                    s2char[j] = (char) temp;
                }
            }
        }
        String s_sorted = new String(s2char);
        System.out.println("有序字符串：" +s_sorted);
        System.out.print("ASCII码：[");
        for (int i = 0; i < s2char.length-1; i++){
            System.out.print((int)s2char[i]+"，");
        }
        System.out.print((int)s2char[s2char.length-1]+"]");
    }
}
