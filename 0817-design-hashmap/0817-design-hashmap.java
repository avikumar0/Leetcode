class MyHashMap {
    private static final int SIZE = 10007; // A prime number for better distribution
    private ListNode[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new ListNode[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % SIZE;
        
        if (buckets[index] == null) {
            buckets[index] = new ListNode(-1, -1);
        }
        
        ListNode prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % SIZE;
        
        if (buckets[index] == null) {
            return -1;
        }
        
        ListNode prev = find(buckets[index], key);
        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % SIZE;
        
        if (buckets[index] == null) {
            return;
        }
        
        ListNode prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    private ListNode find(ListNode bucket, int key) {
        ListNode curr = bucket;
        ListNode prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    private class ListNode {
        int key;
        int value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
