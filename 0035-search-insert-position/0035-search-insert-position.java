class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // Middle index
            int mid = left + (right - left) / 2;

            // Target mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Target bada hai → right side jao
            if (nums[mid] < target) {
                left = mid + 1;
            }

            // Target chhota hai → left side jao
            else {
                right = mid - 1;
            }
        }

        // Target nahi mila
        // left exactly wahi position hai jahan target insert hoga
        return left;
    }
}