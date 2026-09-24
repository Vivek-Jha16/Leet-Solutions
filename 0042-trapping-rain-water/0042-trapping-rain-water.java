class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        // Left side ka maximum height
        int leftMax = 0;

        // Right side ka maximum height
        int rightMax = 0;

        int water = 0;

        // Jab tak pointers cross nahi karte
        while (left <= right) {

            // Left height chhoti hai
            if (height[left] <= height[right]) {

                // Left side ka maximum update karo
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } 
                else {
                    // Current bar ke upar water trap hoga
                    water += leftMax - height[left];
                }

                // Left pointer aage badhao
                left++;
            }

            // Right height chhoti hai
            else {

                // Right side ka maximum update karo
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } 
                else {
                    // Current bar ke upar water trap hoga
                    water += rightMax - height[right];
                }

                // Right pointer peeche lao
                right--;
            }
        }

        return water;
    }
}