package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samar.kumar on 8/18/17.
 */
public class DeleteOperationString {

    public static void main(String[] args) {

        System.out.println(new DeleteOperationString().minDistance("mart" , "kara" ,0));


    }

    private Map<String, Integer> cache = new HashMap<>();
    String originalWord1;
    String originalWord2;

    public int minDistance(String word1, String word2){

        originalWord1 =word1;
        originalWord2 =word2;
        return minDistance( word1,word2, 0);
    }

    public int minDistance(String word1, String word2, int currentValue ) {

        Integer valueFromCache = cache.get(originalWord1+":"+originalWord2);

        if (valueFromCache!=null){

        if (currentValue > valueFromCache ){
            return Integer.MAX_VALUE;
        }

        }


        int returnVal;
        if(word1.length() == 0){
            returnVal =   word2.length();
            cache.put(originalWord1+":"+originalWord2 , returnVal+currentValue);
            return returnVal;

        }else if( word2.length() ==0){
            returnVal =   word1.length();
            cache.put(originalWord1+":"+originalWord2 , returnVal+currentValue);
            return returnVal;
        }

        if(word1.charAt(word1.length()-1) == word2.charAt(word2.length()-1)) {

            if (cache.containsKey(word1 + " : " + word2 )){
                return cache.get(word1 + " : " + word2 );
            }else {
                returnVal = minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1), currentValue);
                cache.put(word1 + " : " + word2 , returnVal+currentValue);

                return cache.get(word1 + " : " + word2);
            }

        }else {
            if (cache.containsKey(word1 + " : " + word2 )){
                return cache.get(word1 + " : " + word2 );
            }else {
                returnVal = Math.min(Math.min(minDistance(word1, word2.substring(0, word2.length() - 1), currentValue + 1),
                        minDistance(word1.substring(0, word1.length() - 1), word2, currentValue + 1)),
                        minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1), currentValue + 2));

                cache.put(word1 + " : " + word2 , returnVal+currentValue);

                System.out.println(word1 + " : " + word2 + " :->" + returnVal);
                return cache.get(word1 + " : " + word2);
            }
        }

    }
}
