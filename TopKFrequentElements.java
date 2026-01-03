import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Approach:
- Count frequency of each element using HashMap.
- Use bucket sort where index represents frequency.
- Traverse buckets from highest frequency and collect k elements.

Time Complexity:
- O(n), where n = number of elements.

Space Complexity:
- O(n) for frequency map and buckets.
*/

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[n + 1];

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }

        int index = 0;
        int[] result = new int[k];

        for (int i=bucket.length-1;i>=0 && index < k;i--) {
            if (bucket[i] != null) {
                for (int val: bucket[i]) {
                    result[index++] = val;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
