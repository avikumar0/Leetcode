class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 2; // At least 2 points are needed for a line.

        for (int i = 0; i < n; i++) {
            // int duplicate = 0;
            int localMax = 1;
            
            for (int j = i + 1; j < n; j++) {
                int count = 1; // Start with 1 for the current point.
                for (int k = j + 1; k < n; k++) {
                    if (isCollinear(points[i], points[j], points[k])) {
                        count++;
                    }
                }
                localMax = Math.max(localMax, count);
            }

            localMax++;
            maxPoints = Math.max(maxPoints, localMax);
        }

        return maxPoints;
    }

    private boolean isCollinear(int[] p1, int[] p2, int[] p3) {
        return (p2[1] - p1[1]) * (p3[0] - p2[0]) == (p3[1] - p2[1]) * (p2[0] - p1[0]);
    }
}
