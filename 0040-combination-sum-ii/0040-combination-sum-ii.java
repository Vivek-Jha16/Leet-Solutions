import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Sorting se duplicates ko easily handle kar sakte hain
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int[] candidates,
        int target,
        int start,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Target 0 = valid combination mil gaya
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Same level par duplicate number skip karo
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Number target se bada hai
            // Sorting ki wajah se aage bhi bade honge
            if (candidates[i] > target) {
                break;
            }

            // Number choose karo
            current.add(candidates[i]);

            // i + 1 pass kar rahe hain
            // kyunki same element dobara use nahi kar sakte
            backtrack(
                candidates,
                target - candidates[i],
                i + 1,
                current,
                result
            );

            // Backtrack: last number remove karo
            current.remove(current.size() - 1);
        }
    }
}