class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 2; // At least 2 points are needed for a line.

        for (int i = 0; i < n; i++) {
            Map<Double, Integer> slopeCount = new HashMap<>();
            int duplicate = 0;
            int localMax = 1;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        duplicate++;
                    } else {
                        double slope;
                        if (points[i][0] == points[j][0]) {
                            slope = Double.POSITIVE_INFINITY;
                        } else {
                            slope = (double) (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                        }
                        slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                        localMax = Math.max(localMax, slopeCount.get(slope));
                    }
                }
            }

            localMax = Math.max(localMax, duplicate) + 1;
            maxPoints = Math.max(maxPoints, localMax);
        }

        return maxPoints-1;
    }
}
