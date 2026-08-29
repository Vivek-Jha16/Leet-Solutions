class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Right se pehla aisa element find karo
        // jiska next element usse bada ho
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Agar i mila, toh right side mein
        // i se bada sabse chhota element find karo
        if (i >= 0) {
            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // i aur j ko swap karo
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: i ke baad ka part reverse karo
        // taaki smallest possible permutation mile
        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}