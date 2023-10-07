class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - b[0]) - (a[1] - a[0])); // Max heap based on yi - xi
        
        int maxVal = Integer.MIN_VALUE;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            while (!maxHeap.isEmpty() && x - maxHeap.peek()[0] > k) {
                maxHeap.poll(); // Remove points that are out of range
            }

            if (!maxHeap.isEmpty()) {
                int[] prevPoint = maxHeap.peek();
                int prevY = prevPoint[1];
                maxVal = Math.max(maxVal, prevY - prevPoint[0] + y + x); // Calculate and update maxVal
            }

            maxHeap.offer(new int[] {x, y});
        }

        return maxVal;
    }
}