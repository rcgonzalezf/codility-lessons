// https://codility.com/demo/results/demoN3XHGT-7GT/ 30%
class MaxDoubleSliceSum {
    public int solution(int[] A) {
      int[] maxStartingHere = new int[A.length];
      int[] maxEndingHere = new int[A.length];
      int maxSum = 0, len = A.length;

      for(int i = len - 2; i > 0; --i ) {
          maxSum = Math.max(0, A[i] + maxSum);
          maxStartingHere[i] = maxSum;
      }
      maxSum = 0;
      for(int i = 1; i < len - 1; ++i ) {
          maxSum = Math.max(0, A[i] + maxSum);
          maxEndingHere[i] = maxSum;
      }
      int maxDoubleSlice = 0;

      for(int i = 0; i < len - 2; ++i) {
          maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i] + maxStartingHere[i+2]);
      }
      return maxDoubleSlice;
    }
}
