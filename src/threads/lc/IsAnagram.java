package threads.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samar.kumar on 8/31/17.
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("ba" ,"ab"));
    }


    public boolean isAnagram(String s, String t) {

        String first, second;
        if(s.length() > t.length()){
            first = s;
            second = t;
        }else {
            first = t;
            second =s;
        }


        Map<Character, Integer> map = new HashMap<>();
        for (char eachChar : second.toCharArray()) {
            if (map.containsKey(eachChar)) {
                map.put(eachChar, map.get(eachChar) + 1);
            } else {
                map.put(eachChar, 1);
            }

        }

        for (char eachCharSecond: first.toCharArray()){
            if (map.containsKey(eachCharSecond)){
                map.put(eachCharSecond, map.get(eachCharSecond) -1);
                if(map.get(eachCharSecond) <0){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;

    }


}
