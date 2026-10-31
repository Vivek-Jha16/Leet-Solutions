class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0; // Current jump ki boundary
        int farthest = 0;   // Maximum reachable index

        // Last index par pahunchne se pehle tak loop
        for (int i = 0; i < nums.length - 1; i++) {

            // Maximum kitna aage ja sakte hain
            farthest = Math.max(farthest, i + nums[i]);

            // Current range khatam ho gaya
            if (i == currentEnd) {
                jumps++;             // Ek jump complete
                currentEnd = farthest; // Next range ki boundary

                // Last index tak pahunch gaye
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
