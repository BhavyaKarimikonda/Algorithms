import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        return getFibonacciHugeNaive(n+1,10)*getFibonacciHugeNaive(n,10)%10 ;
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        long rem = n % pisanoPeriod(m) ;
        long prev = 0;
        long curr = 1;
        long result = rem ;
        for(int i=0; i< rem; i++){
            result = (curr + prev)%m;
            curr = prev;
            prev = result;
        }
       
        return result;
    }
    
    
    private static long pisanoPeriod(long n){
        long pisano = 0;
        long previous = 0 , current = 1, temp;
        for(long i=0; i<n*n; i++){
            temp = previous;
            previous = current;
            current = (temp + current) % n;
            if(previous == 0 && current == 1){
                pisano = i+1;
                break;
            }
        }
        return pisano;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

