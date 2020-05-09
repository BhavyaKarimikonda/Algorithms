import java.util.Scanner;
import java.lang.*;

public class ChangeDP {
    private static int getChange(int money) {
        //write your code here
        int[] coins = {1,3,4};
        int numCoins ;
        int[] minCoins = new int[money+1];
        minCoins[0] = 0;
        for(int m=1; m<=money; m++){
            minCoins[m] = Integer.MAX_VALUE ;
            for(int i=0; i<coins.length; i++){
                if(m >= coins[i]){
                    numCoins = minCoins[m-coins[i]] + 1;
                    if(numCoins < minCoins[m]){
                        minCoins[m] = numCoins;
                    }
                }
            }
        }
        return minCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

