public class FrogJumpK {

    public static int frogJump(int n, int[] heights, int k) {

        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minEnergy = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {

                if (i - j >= 0) {

                    int jump = dp[i - j]
                            + Math.abs(heights[i] - heights[i - j]);

                    minEnergy = Math.min(minEnergy, jump);
                }
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        int[] heights = {10, 20, 30, 10};
        int n = heights.length;
        int k = 3;

        System.out.println(frogJump(n, heights, k));
    }
}