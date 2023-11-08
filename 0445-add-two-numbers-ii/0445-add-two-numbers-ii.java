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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create two stacks to store the reversed digits of the input lists
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        // Populate the stacks by reversing the linked lists
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        // Initialize variables for sum and carry
        int sum = 0, carry = 0;
        ListNode result = null;
        
        // Process the digits in the stacks and add them with carry
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            
            // Calculate the sum for the current position
            int currentSum = x + y + carry;
            carry = currentSum / 10;  // Calculate the carry for the next position
            
            // Create a new node for the current digit and link it to the result list
            ListNode newNode = new ListNode(currentSum % 10);
            newNode.next = result;
            result = newNode;
        }
        
        return result;
    }
}
