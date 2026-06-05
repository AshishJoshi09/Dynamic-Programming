/*You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.

Note:
A subsequence of an array/list is obtained by deleting some number of elements (can be zero) from the array/list, leaving the remaining elements in their original order.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 500
1 <= N <= 1000
0 <= ARR[i] <= 10^5

Where 'ARR[i]' denotes the 'i-th' element in the array/list.

Time Limit: 1 sec.
Sample Input 1:
2
3
1 2 4
4
2 1 4 9
Sample Output 1:
5
11
Explanation to Sample Output 1:
In test case 1, the sum of 'ARR[0]' & 'ARR[2]' is 5 which is greater than 'ARR[1]' which is 2 so the answer is 5.

In test case 2, the sum of 'ARR[0]' and 'ARR[2]' is 6, the sum of 'ARR[1]' and 'ARR[3]' is 10, and the sum of 'ARR[0]' and 'ARR[3]' is 11. So if we take the sum of 'ARR[0]' and 'ARR[3]', it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.
Sample Input 2:
2
5
1 2 3 5 4
9
1 2 3 1 3 5 8 1 9
Sample Output 2:
8
24
Explanation to Sample Output 2:
In test case 1, out of all the possibilities, if we take the sum of 'ARR[0]', 'ARR[2]' and 'ARR[4]', i.e. 8, it will give the maximum sum of sequence in which no elements are adjacent in the given array/list.

In test case 2, out of all the possibilities, if we take the sum of 'ARR[0]', 'ARR[2]', 'ARR[4]', 'ARR[6]' and 'ARR[8]', i.e. 24 so, it will give the maximum sum of sequence in which no elements are adjacent in the given array/list */

import java.util.ArrayList;
import java.util.Arrays;


// Recursion, TC = O(2power n) sc - O(n) for recursion array
// public class maxNonAdjSum
// {
// 	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) 
// 	{
// 		return solve(nums, nums.size() - 1);
		
// 	}

// 	static int solve(ArrayList<Integer> nums, int index){
		
// 		if(index == 0){
// 			return nums.get(0);
// 		}

// 		 if(index < 0){
//             return 0;
//         }

// 		int pick = nums.get(index) + solve(nums, index - 2);

// 		int notPick = 0 + solve(nums, index - 1);

// 		return Math.max(pick, notPick);
// 	}
// 	public static void main(String[] args) {
// 		ArrayList<Integer> nums = new ArrayList<>();

//         nums.add(1);
//         nums.add(2);
//         nums.add(3);
//         nums.add(1);
//         nums.add(3);
//         nums.add(5);
//         nums.add(8);
//         nums.add(1);
//         nums.add(9);

//         System.out.println(maximumNonAdjacentSum(nums));
// 	}
// }

// Memoization TC - O(n), SC- O(n) dp array + O(n) for recursion stack

// public class maxNonAdjSum
// {
// 	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) 
// 	{
// 		int[] dp = new int[nums.size()];
// 		Arrays.fill(dp, -1);
// 		return solve(nums, nums.size() - 1, dp);
		
// 	}

// 	static int solve(ArrayList<Integer> nums, int index, int[] dp){
		
// 		if(index == 0){
// 			return nums.get(0);
// 		}

// 		if(index < 0){
//             return 0;
//         }

// 		if(dp[index] != -1){
// 			return dp[index];
// 		}

// 		int pick = nums.get(index) + solve(nums, index - 2, dp);

// 		int notPick = 0 + solve(nums, index - 1, dp);

// 		return dp[index] = Math.max(pick, notPick);
// 	}
// 	public static void main(String[] args) {
// 		ArrayList<Integer> nums = new ArrayList<>();

//         nums.add(1);
//         nums.add(2);
//         nums.add(3);
//         nums.add(1);
//         nums.add(3);
//         nums.add(5);
//         nums.add(8);
//         nums.add(1);
//         nums.add(9);

//         System.out.println(maximumNonAdjacentSum(nums));
// 	}
// }

// Tabulation TC-O(n)  SC -O(n) for dp no recursion stack 

// public class maxNonAdjSum
// {
// 	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) 
// 	{
// 		int[] dp = new int[nums.size()];
// 		Arrays.fill(dp, -1);
// 		return solve(nums, nums.size() - 1, dp);
		
// 	}

// 	static int solve(ArrayList<Integer> nums, int index, int[] dp){
		
// 		dp[0] = nums.get(0);

// 		for(int i = 1 ; i < nums.size(); i++){
			 
// 		int pick = nums.get(i) ;
// 		if(i > 1){
// 			pick += dp[i-2];
// 		}

// 		int notPick = 0 + dp[i-1];

// 	    dp[i] = Math.max(pick, notPick);
// 		}

// 		return dp[index];

// 	}
// 	public static void main(String[] args) {
// 		ArrayList<Integer> nums = new ArrayList<>();

//         nums.add(1);
//         nums.add(2);
//         nums.add(3);
//         nums.add(1);
//         nums.add(3);
//         nums.add(5);
//         nums.add(8);
//         nums.add(1);
//         nums.add(9);

//         System.out.println(maximumNonAdjacentSum(nums));
// 	}
// }


// Tabulation + space optimization  TC - O(n)  SC - O(1)

public class maxNonAdjSum
{
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) 
	{
		return solve(nums, nums.size() - 1);
	}

	static int solve(ArrayList<Integer> nums, int index){
		
		int prev1 = nums.get(0);
		int prev2 = 0;

		for(int i = 1 ; i < nums.size(); i++){
			 
		int pick = nums.get(i) ;
		if(i > 1){
			pick += prev2;
		}

		int notPick = 0 + prev1;

	    int curr = Math.max(pick, notPick);

		prev2 = prev1;
		prev1 = curr;
		}

		return prev1;

	}
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(8);
        nums.add(1);
        nums.add(9);

        System.out.println(maximumNonAdjacentSum(nums));
	}
}