class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> counts = new ArrayList<>();
        int[] result = new int[n];
        int[] indexes = new int[n];

        for (int i = 0; i < n; i++) {
            counts.add(0);
            indexes[i] = i;
        }

        mergeSort(nums, indexes, result, counts, 0, n - 1);

        return counts;
    }

    private void mergeSort(int[] nums, int[] indexes, int[] result, List<Integer> counts, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, indexes, result, counts, start, mid);
        mergeSort(nums, indexes, result, counts, mid + 1, end);

        merge(nums, indexes, result, counts, start, mid, end);
    }

    private void merge(int[] nums, int[] indexes, int[] result, List<Integer> counts, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];

        int index = 0;
        while (left <= mid && right <= end) {
            if (nums[indexes[right]] < nums[indexes[left]]) {
                newIndexes[index] = indexes[right];
                rightCount++;
                right++;
            } else {
                newIndexes[index] = indexes[left];
                counts.set(indexes[left], counts.get(indexes[left]) + rightCount);
                left++;
            }
            index++;
        }

        while (left <= mid) {
            newIndexes[index] = indexes[left];
            counts.set(indexes[left], counts.get(indexes[left]) + rightCount);
            left++;
            index++;
        }

        while (right <= end) {
            newIndexes[index] = indexes[right];
            right++;
            index++;
        }

        for (int i = start; i <= end; i++) {
            indexes[i] = newIndexes[i - start];
        }
    }
}
