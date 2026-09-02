class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // Middle element find karo
            int mid = left + (right - left) / 2;

            // Target mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Check karo left half sorted hai
            if (nums[left] <= nums[mid]) {

                // Target left sorted half ke andar hai
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // Target right half mein hai
                    left = mid + 1;
                }

            } else {

                // Right half sorted hai
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // Target left half mein hai
                    right = mid - 1;
                }
            }
        }

        // Target array mein nahi mila
        return -1;
    }
}