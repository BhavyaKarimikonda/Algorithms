import java.util.*;

public class GCD {
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

    System.out.println(gcd_naive(a, b));
  }
}
