import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = exp.length() / 2 + 1;
        int[] num = new int[n];
        long[][] min = new long[n][n];
        long[][] max = new long[n][n];
        for(int i=0; i<n; i++){
            num[i] = exp.charAt(i*2) - '0' ;
            min[i][i] = num[i];
            max[i][i] = num[i];
        }
        char[] op = new char[n-1] ;
        for(int i=0; i<n-1; i++){
            op[i] = exp.charAt(i*2 + 1);
        }
        for (int size = 1; size <= n - 1; size++) {
            for (int i = 0; i <= n - 1 - size; i++) {
                int j = size + i;
                long[] minmax = minAndMax(i, j, min, max, op);
                min[i][j] = minmax[0]; 
                max[i][j] = minmax[1];
            }
        }
        return max[0][n - 1];
    }

    private static long[] minAndMax( int i, int j, long[][] min, long[][] max, char[] ops) {
        long[] minmax = new long[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int k = i; k <= j - 1; k++) {
            char op = ops[k];

            long a = eval(min[i][k], min[k + 1][j], op);
            long b = eval(min[i][k], max[k + 1][j], op);
            long c = eval(max[i][k], min[k + 1][j], op);
            long d = eval(max[i][k], max[k + 1][j], op);

            minmax[0] = Math.min(a, Math.min(b, Math.min(c, Math.min(d, minmax[0]))));
            minmax[1] = Math.max(a, Math.max(b, Math.max(c, Math.max(d, minmax[1]))));
        }
        return minmax;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

