import java.util.*;

public class EditDistance {
  public static int EditDistance(String s1, String t1) {
    //write your code here
    
    int m = s1.length() + 1 ;
    int n = t1.length() + 1 ;
    char[] s = s1.toCharArray();
    char[] t = t1.toCharArray();
    int[][] ed = new int[m][n] ;
    for(int i=0; i<m; i++){
      ed[i][0] = i;
    }
    for(int j=1 ; j<n ; j++){
      ed[0][j] = j;
    }

    for(int i=1; i<m ; i++){
      for(int j=1; j<n; j++){
        if(s[i-1] == t[j-1]){
          ed[i][j] = min(ed[i][j-1]+1, ed[i-1][j]+1, ed[i-1][j-1]);
        }
        else{
          ed[i][j] = min(ed[i][j-1]+1, ed[i-1][j]+1, ed[i-1][j-1]+1);
        }
      }
    }
    return ed[m-1][n-1];
  }

  public static int min(int a, int b , int c){
        return Math.min(Math.min(a, b), c) ;
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
