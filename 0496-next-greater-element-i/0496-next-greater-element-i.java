class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Create a stack to store elements from nums2
        Deque<Integer> stack = new ArrayDeque<>();
        // Create a map to store the next greater element
        Map<Integer, Integer> nextGreater = new HashMap<>();

        // Iterate through nums2 to find the next greater element for each element
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Initialize the result array with -1 for elements not found
        int[] result = new int[nums1.length];

        // Fill the result array with the next greater elements from the map
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}