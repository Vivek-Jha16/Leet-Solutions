/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        // Previous node
        ListNode prev = head;

        // Current node
        ListNode curr = head.next;

        // Position of current node
        int pos = 1;

        // First critical point ki position
        int first = -1;

        // Previous critical point ki position
        int last = -1;

        while (curr != null && curr.next != null) {

            // Check karo current node local minimum ya maximum hai
            boolean critical =
                (curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val);

            if (critical) {

                // Agar pehla critical point hai
                if (first == -1) {
                    first = pos;
                }

                // Agar previous critical point already hai
                if (last != -1) {

                    // Current aur previous critical point ka distance
                    int distance = pos - last;

                    // Minimum distance update
                    minDistance = Math.min(minDistance, distance);
                }

                // Maximum distance first aur current ke beech
                maxDistance = pos - first;

                // Current ko last critical point bana do
                last = pos;
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        // 2 se kam critical points
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}