class Solution {
    public String countAndSay(int n) {

        // First term hamesha "1" hota hai
        String result = "1";

        // 2 se n tak next terms banao
        for (int i = 2; i <= n; i++) {

            StringBuilder next = new StringBuilder();

            int count = 1;

            // Current string ke characters check karo
            for (int j = 1; j <= result.length(); j++) {

                // Same character mila toh count badhao
                if (j < result.length() && result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } 
                else {
                    // Count + character add karo
                    next.append(count);
                    next.append(result.charAt(j - 1));

                    // Next group ke liye count reset
                    count = 1;
                }
            }

            // Next term ko current result bana do
            result = next.toString();
        }

        return result;
    }
}