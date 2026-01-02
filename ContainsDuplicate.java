import java.util.*;;

// Approach: Use HashMap to track seen numbers
// Time: O(n), Space: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }
}