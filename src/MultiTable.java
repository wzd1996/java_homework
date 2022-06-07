public class MultiTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            String output_line = "";
            for (int j = 1; j <= 9; j++) {
                if (i < j) {
                    break;
                }
                output_line = output_line + j + "*" + i + "=" + (i * j) + "\t";
            }
            System.out.println(output_line);
        }
    }
}
