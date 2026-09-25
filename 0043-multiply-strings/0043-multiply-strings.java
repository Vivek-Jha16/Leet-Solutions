class Solution {
    public String multiply(String num1, String num2) {

        // Agar kisi number me 0 hai
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        // Maximum answer length = n + m
        int[] result = new int[n + m];

        // num1 ke digits traverse karo
        for (int i = n - 1; i >= 0; i--) {

            // num2 ke digits traverse karo
            for (int j = m - 1; j >= 0; j--) {

                // Character ko digit me convert karo
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Current multiplication
                int product = digit1 * digit2;

                // Result me correct positions
                int pos1 = i + j;
                int pos2 = i + j + 1;

                // Existing value + product
                int sum = product + result[pos2];

                // Carry ko left position me add karo
                result[pos1] += sum / 10;

                // Current digit store karo
                result[pos2] = sum % 10;
            }
        }

        // int[] ko String me convert karo
        StringBuilder answer = new StringBuilder();

        for (int digit : result) {

            // Starting ke zero ignore karo
            if (answer.length() == 0 && digit == 0) {
                continue;
            }

            answer.append(digit);
        }

        return answer.toString();
    }
}