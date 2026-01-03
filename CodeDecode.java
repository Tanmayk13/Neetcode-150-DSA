import java.util.ArrayList;
import java.util.List;

/*
Approach:
- Encode each string as: length + '#' + string.
- While decoding, read length first, then extract that many characters.
- This avoids delimiter collision issues.

Time Complexity:
- O(n), where n = total number of characters.

Space Complexity:
- O(1) extra space (excluding output).
*/

public class CodeDecode {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strList = new ArrayList<>();
        
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            j++;

            String s = str.substring(j, j + length);
            strList.add(s);

            i = j + length;
        }

        return strList;
    }
}
