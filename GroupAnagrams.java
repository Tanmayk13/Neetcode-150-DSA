import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Approach:
- Use a HashMap where key represents character frequency of a string.
- For each word, count occurrences of 26 lowercase letters.
- Convert frequency array to a string key and group words by this key.

Time Complexity:
- O(n * k), where n = number of strings, k = max length of a string.

Space Complexity:
- O(n * k) for hashmap storage and output.
*/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] freq = new int[26];

            for (int i=0;i<s.length();i++) {
                freq[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder(52);

            for (int count: freq) {
                sb.append("#");
                sb.append(count);
            }

            String key = sb.toString();

            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(s);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
        
    }
}
