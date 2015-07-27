// https://codility.com/demo/results/demoZQ8B69-A24/ 11
// https://codility.com/demo/results/demoYTZ82F-2AZ/ 33
// https://codility.com/demo/results/demoHECS6Y-NF5/ 100

public class PassingCars {
  // [0,0,0,0,0] = 0
  // [0,0,1,1,1,1] = 8
  // [0,0,1,1,1,1,0] = 8
  // [1,0] = 0
  // [0,1,1,1,1,1,1,0] = 6
  // [1,1,1,1,0,1,0] = 1
  // [1,1,1,1,0,1,1,0,1] = 4
  class Solution {
    public static final int FAIL = -1;

    public int solution(int[] A) {
        int N = A.length;

        if ( N < 2) { return 0; }

        int onesCount = 0;
        boolean zeroHappenedBefore = false;
        for (int i =0; i < N; ++i ) {
            if(zeroHappenedBefore && A[i] == 1 ) {
                ++onesCount;
            } else if (A[i] == 0) {
                zeroHappenedBefore = true;
            }
        }

        if (onesCount ==0) { return 0; }

        long combinations = 0;
        int conditionReturnFail = 1000000000;
        zeroHappenedBefore = false;

        for (int i=0; i < N; ++i) {
            if (A[i] == 0) {
                combinations += onesCount;
                if(conditionReturnFail < combinations) {
                    return FAIL;
                }
                zeroHappenedBefore = true;
            } else {
                if (zeroHappenedBefore) {
                    --onesCount;
                }
            }
        }

        return (int) combinations;
    }
}

}
