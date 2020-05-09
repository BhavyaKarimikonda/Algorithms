import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] wt) {
        //write you code here
        int n = wt.length ;
        int[][] value = new int[W+1][n+1] ;
        for(int i=0; i<=n; i++){
          value[0][i] = 0;
        }
        for(int i=0; i<=W; i++){
          value[i][0] = 0;
        }
        for(int i=1; i<=n; i++){
          for(int w=1; w<=W; w++){
            value[w][i] = value[w][i-1];
            if(wt[i-1] <= w){
              int val = value[w-wt[i-1]][i-1] + wt[i-1];
              if(value[w][i] < val ){
                value[w][i] = val;
              } 
            }
          }
        }
        return value[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

