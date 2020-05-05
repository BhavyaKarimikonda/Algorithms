import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int num = 0;
        if(m/10 >= 1){
            num = m/10;
            m = m%10;
        }
        if(m/5 >= 1){
            num = num + m/5;
        }
        num = num + m%5;
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

