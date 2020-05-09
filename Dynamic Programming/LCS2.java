import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        return EditDistance(a,b);
    }


    public static int EditDistance(int[] s, int[] t) {
        int m = s.length  ;
        int n = t.length  ;
        int[][] ed = new int[m+1][n+1] ;

        for(int i=1; i<=m ; i++){
          for(int j=1; j<=n; j++){
            if(s[i-1] == t[j-1]){
              ed[i][j] = ed[i-1][j-1] + 1; 
            }
            else{
              ed[i][j] = Math.max(ed[i][j-1], ed[i-1][j]);
            }
          }
        }
        return ed[m][n];
    
}
      

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

