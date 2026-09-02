class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean hasEven = false;
        boolean hasOdd = false;

        // Array me odd aur even numbers check karo
        for (int num : nums1) {
            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        // Agar sab same parity ke hain, directly possible
        if (!hasEven || !hasOdd) {
            return true;
        }

        // Odd aur even dono hain
        // Odd - Even = Odd
        // Even - Odd = Odd
        // Isliye har element ko odd banaya ja sakta hai
        return true;
    }
}