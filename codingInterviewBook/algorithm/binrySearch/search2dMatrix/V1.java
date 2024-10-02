package algorithm.binrySearch.search2dMatrix;

// My solution - bs 2번
public class V1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] searchedArr = binarySearchForMatrix(matrix, target);
        return searchedArr != null && binarySearch(searchedArr, target);
    }

    private int[] binarySearchForMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] subArr = matrix[mid];
            if (subArr[0] > target) {
                right = mid - 1;
            } else if (subArr[subArr.length - 1] < target) {
                left = mid + 1;
            } else {
                return subArr;
            }
        }
        return null;
    }

    private boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
