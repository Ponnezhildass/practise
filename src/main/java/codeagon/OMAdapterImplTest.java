package  codeagon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OMAdapterImplTest {

    static Set<Character> valid;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        valid = new HashSet(Arrays.asList(
                new Character[] {'A','H','I','i','M','m','O','o','T','U','V','v','W','w','X','x','Y'}));

        String line = in.readLine();
        if (isSPalen(line))
            System.out.println("TAK");
        else
            System.out.println("NIE");
    }

    static boolean isSPalen(String str) {
        if (str.length() == 0) {
            return true;
        }
        Character fst = str.charAt(0);
        Character lst = str.charAt(str.length()-1);

        if (str.length() == 1) {
            return valid.contains(fst);
        }

        if ((fst == 'b' && lst == 'd') || (lst == 'b' && fst == 'd')) {
            return isSPalen(str.substring(1, str.length()-1)); // check
        }
        if ((fst == 'p' && lst == 'q') || (lst == 'p' && fst == 'q')) {
            return isSPalen(str.substring(1, str.length()-1)); // check
        }
        if (fst == lst && valid.contains(fst)) {
            return isSPalen(str.substring(1, str.length()-1)); // check
        }

        return false;
    }
}