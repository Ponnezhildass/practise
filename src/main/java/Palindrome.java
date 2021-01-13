import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Palindrom {

    public String longestPalindrome(String s) {
        int size = s.length();
        if (size == 0) return "";
        int a = 0, b = 0;
        int max = 1;
        int[][] p = new int[size][size];
        for (int i = 0; i < size; i++)
            p[i][i] = 1;
        for (int j = 1; j < size; j++) {
            for (int i = 0; i < size-j; i++) {
                if ((s.charAt(i) == s.charAt(i+j)) && (p[i + 1][i+ j - 1] > 0 || j == 1)) {
                    p[i][i+j] = p[i + 1][i+ j - 1] + 2;
                    max = Math.max(max, p[i][i+j]);
                    if (max == p[i][i+j]) {
                        a = i;
                        b = i+j;
                    }
                }
            }
        }
        return s.substring(a, b + 1);
    }
}

public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {

            String ret = new Palindrom().longestPalindrome(line);

            String out = (ret);

            System.out.print(out);
        }
    }
}