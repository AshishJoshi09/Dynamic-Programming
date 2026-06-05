import java.util.Arrays;

//memoization
/*class Main {
    
   static int[] dp = new int[100];
       
        static int fib(int n){
           if(n<=1){
               return n;
           }
           if(dp[n] != -1){
               return dp[n];
           }
           int result = fib(n-1) + fib(n-2);
           
           
            dp[n] = result;
               return result;
       }
       
    public static void main(String[] args) {
        
       
       Arrays.fill(dp, -1);
        System.out.println(fib(10));
    }
}*/

//tabulation

/*public class Main {

    static int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " is: " + fib(n));
    }
}*/

//space - O(1)

public class fib {

    static int fib(int n) {
        if (n <= 1) return n;

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}  