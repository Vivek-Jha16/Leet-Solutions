class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Combinations find karna start karo
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

        // Target exactly 0 ho gaya = valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Candidates try karo
        for (int i = start; i < candidates.length; i++) {

            // Number target se bada hai toh skip
            if (candidates[i] > target) {
                continue;
            }

            // Number choose karo
            current.add(candidates[i]);

            // i hi pass kar rahe hain
            // kyunki same number dobara use kar sakte hain
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Number remove karo (backtrack)
            current.remove(current.size() - 1);
        }
    }
}