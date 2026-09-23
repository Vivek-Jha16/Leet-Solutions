class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Har number ko uske correct index par place karo
        // Example: 1 -> index 0, 2 -> index 1, 3 -> index 2
        for (int i = 0; i < n; i++) {

            while (nums[i] >= 1 &&
                   nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                // Number ko correct position par swap karo
                int temp = nums[i];

                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Ab check karo kaunsa number apni correct position par nahi hai
        for (int i = 0; i < n; i++) {

            // Index 0 par 1, index 1 par 2...
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Agar 1 se n tak sab present hain
        return n + 1;
    }
}