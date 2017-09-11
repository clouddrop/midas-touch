package lc;

/**
 * Created by samar.kumar on 8/19/17.
 */
public class Solution {

    public boolean detectCapitalUse(String word) {
        if(word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())){
            return true;
        }else if(word.substring(1).equals(word.substring(1).toLowerCase())){
            return true;
        }else return false;

    }

}
