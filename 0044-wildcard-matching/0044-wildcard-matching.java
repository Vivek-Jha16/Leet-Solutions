class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0; // String ka pointer
        int j = 0; // Pattern ka pointer

        int star = -1; // Last * ka index
        int match = 0; // * se match hone wale string ka index

        while (i < s.length()) {

            // Same character ya ? match kare
            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }

            // * mila: zero characters se match karne ki try
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }

            // Pehle * mila tha, ab usse ek aur character match karao
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }

            // Match possible nahi hai
            else {
                return false;
            }
        }

        // Pattern ke end me extra * ignore karo
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}