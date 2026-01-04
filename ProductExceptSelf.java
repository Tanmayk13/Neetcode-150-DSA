/*
Approach:
- First pass: store prefix product (product of elements to the left) in the result array.
- Second pass: maintain a running suffix product from the right and multiply it into result.
- No division is used and no extra arrays are created.

Time Complexity: O(n)
Space Complexity: O(1) extra space (output array not counted)
*/

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return ans;
    }
}
