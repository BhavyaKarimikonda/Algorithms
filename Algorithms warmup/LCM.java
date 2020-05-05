import java.util.*;
import java.lang.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    int gcd = gcd_naive(a,b);
    long lcm = (long)a*b/gcd;
    return lcm;
  }
  
  private static int gcd_naive(int a, int b) {
        int temp = b;
        b = a%b ;
        a = temp;
        if(b != 0){
              return gcd_naive(a,b);
        }
        return a;
     }

public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.println(lcm_naive(a, b));
  }
}
