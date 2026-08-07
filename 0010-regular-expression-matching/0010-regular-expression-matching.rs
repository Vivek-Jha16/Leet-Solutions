impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        fn dp(
            i: usize,
            j: usize,
            s: &[u8],
            p: &[u8],
            memo: &mut Vec<Vec<Option<bool>>>,
        ) -> bool {
            if let Some(ans) = memo[i][j] {
                return ans;
            }

            let ans = if j == p.len() {
                i == s.len()
            } else {
                let first_match =
                    i < s.len() && (p[j] == b'.' || p[j] == s[i]);

                if j + 1 < p.len() && p[j + 1] == b'*' {
                    dp(i, j + 2, s, p, memo)
                        || (first_match && dp(i + 1, j, s, p, memo))
                } else {
                    first_match && dp(i + 1, j + 1, s, p, memo)
                }
            };

            memo[i][j] = Some(ans);
            ans
        }

        let s = s.as_bytes();
        let p = p.as_bytes();

        let mut memo = vec![vec![None; p.len() + 1]; s.len() + 1];

        dp(0, 0, s, p, &mut memo)
    }
}