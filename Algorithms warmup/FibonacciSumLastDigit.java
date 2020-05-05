import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        long k = n+2;
        long kres = getFibonacciHugeNaive(k,10);
        if(kres < 1)kres = kres + 10;
        return kres>1?(kres-1)%10 : 1-kres%10 ;
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
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

