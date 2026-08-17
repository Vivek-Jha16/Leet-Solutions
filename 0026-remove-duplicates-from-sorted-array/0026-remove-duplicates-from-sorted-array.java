class Solution {
    public int removeDuplicates(int[] nums) {

        // k unique elements ka position maintain karega
        int k = 1;

        // First element already unique hai,
        // isliye index 1 se start karenge
        for (int i = 1; i < nums.length; i++) {

            // Agar current element previous element se different hai,
            // matlab ye ek naya unique element hai
            if (nums[i] != nums[i - 1]) {

                // Unique element ko k position par rakho
                nums[k] = nums[i];

                // Next unique element ke liye k badhao
                k++;
            }
        }

        // Total unique elements
        return k;
    }
}