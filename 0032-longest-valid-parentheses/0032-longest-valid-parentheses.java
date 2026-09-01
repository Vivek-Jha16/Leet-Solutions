class Solution {
    public int longestValidParentheses(String s) {

        // Stack mein indices store karenge
        Stack<Integer> stack = new Stack<>();

        // Base index
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                // Opening bracket ka index store karo
                stack.push(i);

            } else {

                // Closing bracket ke liye ek opening bracket remove karo
                stack.pop();

                if (stack.isEmpty()) {

                    // Valid substring ka base update karo
                    stack.push(i);

                } else {

                    // Current valid substring ki length
                    int length = i - stack.peek();

                    // Maximum length update
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}