import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;
    
    long[] fib = new long[n+1];
    fib[0] = 0;
    fib[1] = 1;
    for(int i=2; i<n+1; i++){
        fib[i] = (long)(fib[i-1] + fib[i-2]);
    }
    return fib[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
