impl Solution {
    pub fn reverse(x: i32) -> i32 {
        let mut x = x;
        let mut rev: i32 = 0;

        while x != 0 {
            let digit = x % 10;
            x /= 10;

            if rev > i32::MAX / 10 || (rev == i32::MAX / 10 && digit > 7) {
                return 0;
            }
            if rev < i32::MIN / 10 || (rev == i32::MIN / 10 && digit < -8) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        rev
    }
}