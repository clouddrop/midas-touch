package lc;

/**
 * Created by samar.kumar on 9/10/17.
 */
public class FindLUSlength {

    public int findLUSlength(String a, String b) {

        String[] result = a.split(b);
        String longestString = "";
        for (String eachString: result){
            if (eachString.length() > longestString.length()){
                longestString = eachString;
            }
        }
        return longestString.length();

    }


}
