/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // Step 1: Duplicate each node and insert it next to the original node
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }
        
        // Step 2: Update the random pointers of the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        // Step 3: Split the combined list into two separate lists
        Node original = head;
        Node copied = head.next;
        Node copiedHead = head.next;
        while (original != null) {
            original.next = copied.next;
            original = original.next;
            if (original != null) {
                copied.next = original.next;
                copied = copied.next;
            }
        }
        
        return copiedHead;
    }
}
