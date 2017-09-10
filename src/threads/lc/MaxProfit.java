package threads.lc;

/**
 * Created by samar.kumar on 9/4/17.
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] array =  {7,1,5,3,4 ,6};
        System.out.println(new MaxProfit().integerBreak(6));
    }


    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }else if(n==0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1;  i<=n-2 ; i++){
            int currentProduct =0;
            if(n-i ==2){
                currentProduct = i *2 ;
            }else if(n-i ==3){
                currentProduct = i *3 ;
            }else{
                currentProduct = i * integerBreak(n-i);
            }
            if(currentProduct > max){
                max = currentProduct;
            }
        }

        return max;

    }



    public int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;

            System.out.println(prevNo + " : " + prevYes);
        }


        return Math.max(prevNo, prevYes);



    }


    public int maxProfit(int[] prices) {

        int firstPos = 0;
        int finalDiff = prices[0] - prices[0];
        for(int i=1; i<prices.length ; i++ ){
            int currentDiff = prices[i] - prices[firstPos];
            if(currentDiff > finalDiff){
                finalDiff = currentDiff;
            }
            if(prices[i] < prices[firstPos]){
                firstPos = i;

            }
        }

        return finalDiff;

    }
}


