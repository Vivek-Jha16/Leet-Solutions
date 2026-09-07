class Solution {
    public int[] searchRange(int[] nums, int target) {

        // First occurrence find karo
        int first = findFirst(nums, target);

        // Agar target mila hi nahi
        if (first == -1) {
            return new int[]{-1, -1};
        }

        // Last occurrence find karo
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    // Target ka first index find karta hai
    private int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;

                // Target aur left side me ho sakta hai
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                // Target right side me hai
                left = mid + 1;
            }
            else {
                // Target left side me hai
                right = mid - 1;
            }
        }

        return ans;
    }

    // Target ka last index find karta hai
    private int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;

                // Target aur right side me ho sakta hai
                left = mid + 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}