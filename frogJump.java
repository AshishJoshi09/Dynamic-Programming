/*There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.*/

import java.util.Arrays;

// Memoization
// public class frogJump {

//     public static int frogJump(int n, int[] heights) {
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         return solve(n-1, heights, dp);
//     }

//     static int solve(int index, int[] heights, int[] dp){
        
//         if(index == 0){
//             return 0;
//         }
//         if(dp[index] != -1){
//             return dp[index];
//         }

//         int oneJump = solve(index-1, heights, dp) + Math.abs(heights[index] - heights[index-1]);
//         int twoJump = Integer.MAX_VALUE;

//         if(index > 1){
//             twoJump = solve(index-2, heights, dp) + Math.abs(heights[index] - heights[index-2]);
//         }
//         dp[index] = Math.min(oneJump, twoJump);
//         return dp[index];
//     }

//     public static void main(String[] args) {
//         int n = 4;
//         int[] heights = new int[]{10,20,30,10};
//         System.out.println(frogJump(n, heights));

//     }

// }


// tabulation
// public class frogJump {

//     public static int frogJump(int n, int[] heights) {
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
        
//         dp[0] = 0;

//         for(int i =1; i < heights.length ;i++){
//             int oneJump = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
//              int twoJump = Integer.MAX_VALUE;

//             if(i > 1){
//                 twoJump = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
//             }

//             dp[i] = Math.min(oneJump, twoJump);
//         }
//         return dp[n-1];
//     }


//     public static void main(String[] args) {
//         int n = 4;
//         int[] heights = new int[]{10,20,30,10};
//         System.out.println(frogJump(n, heights));

//     }

// }

// Space optimization

public class frogJump {

    public static int frogJump(int n, int[] heights) {
        
        int  prev1 = 0;
        int prev2 = 0;

        for(int i =1; i < heights.length ;i++){
            int oneJump = prev1 + Math.abs(heights[i] - heights[i-1]);
             int twoJump = Integer.MAX_VALUE;

            if(i > 1){
                twoJump = prev2 + Math.abs(heights[i] - heights[i-2]);
            }

            int curr = Math.min(oneJump, twoJump);
            prev2 = prev1;
            prev1 = curr; 
        }
        return prev1;
    }


    public static void main(String[] args) {
        int n = 4;
        int[] heights = new int[]{10,20,30,10};
        System.out.println(frogJump(n, heights));

    }

}