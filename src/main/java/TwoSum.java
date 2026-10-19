
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                return new int[]{
                        indexMap.get(complement),
                        i
                };
            }

            indexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
