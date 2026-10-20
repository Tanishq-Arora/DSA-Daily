
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * Returns true if any value appears at least twice.
     *
     * @param nums input integer array
     * @return true if a duplicate exists, otherwise false
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
