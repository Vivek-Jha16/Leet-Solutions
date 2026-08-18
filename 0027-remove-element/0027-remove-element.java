class Solution {
    public int removeElement(int[] nums, int val) {

        // k batayega ki kitne valid elements mile hain
        int k = 0;

        // Puri array ko check karenge
        for (int i = 0; i < nums.length; i++) {

            // Agar current element val ke equal nahi hai
            if (nums[i] != val) {

                // Valid element ko starting mein rakho
                nums[k] = nums[i];

                // Next valid element ke liye k badhao
                k++;
            }
        }

        // Total elements jo val ke equal nahi hain
        return k;
    }
}