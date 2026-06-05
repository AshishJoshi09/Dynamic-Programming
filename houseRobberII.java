import java.util.ArrayList;


//Time: O(N)
//Space: O(N) (because of temp1 and temp2)

public class houseRobberII {

    public static long houseRobber(ArrayList<Integer> valueInHouse) {

        int n = valueInHouse.size();

        if (n == 1) {
            return valueInHouse.get(0);
        }

        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i != 0) {
                temp1.add(valueInHouse.get(i));
            }

            if (i != n - 1) {
                temp2.add(valueInHouse.get(i));
            }
        }

        return Math.max(solve(temp1), solve(temp2));
    }

    static long solve(ArrayList<Integer> nums) {

        long prev1 = nums.get(0);
        long prev2 = 0;

        for (int i = 1; i < nums.size(); i++) {

            long pick = nums.get(i);

            if (i > 1) {
                pick += prev2;
            }

            long notPick = prev1;

            long curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(6);

        System.out.println(houseRobber(nums));
    }
}