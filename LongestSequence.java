import java.util.HashSet;
import java.util.Set;
/*
Approach:
- Use the result array to store prefix products.
- Traverse from the right with a running suffix product and multiply it into result.
- Optimizes space by avoiding separate prefix and suffix arrays.

Time Complexity: O(n)
Space Complexity: O(1) extra space (excluding output array)
*/


public class LongestSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        Set<Integer> set = new HashSet<>();
        int len = 1;
        int maxLen = 1;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int it = num + 1;
                while (set.contains(it)) {
                    len++;
                    it++;
                }
                maxLen = Math.max(len, maxLen);
                len = 1;
            }
        }

        return maxLen;
    }
}
