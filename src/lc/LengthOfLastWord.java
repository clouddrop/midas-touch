package lc;

/**
 * Created by samar.kumar on 9/6/17.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello "));
    }

    public int lengthOfLastWord(String s) {

        int i = 0;
        if (s.trim().isEmpty()) {
            return 0;
        }


        s= s.trim();
        for (i = s.length() - 1; i > -1 && s.charAt(i) != ' '; i--) {

        }
        if (i == -1) {
            return s.length();
        }
        return s.length() - i -1 ;


    }
}
