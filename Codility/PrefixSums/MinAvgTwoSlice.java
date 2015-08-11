
// https://codility.com/demo/results/demoYRTAB2-3SJ/ 100/20 60%
// https://codility.com/demo/results/demo4S4VJX-WMJ/ 100/100
public class MinAvgTwoSlice {

    public int solution(int[] A) {
        int len = A.length, result = len - 1, sum = 0;
        int[] prefixSums = new int[len + 1];

        for (int i = 1; i <= len; ++i) {
            prefixSums[i] = prefixSums[i-1] + A[i-1];
        }

        double min = Double.MAX_VALUE, average = 0d;

        for (int P = 0, Q = 1; Q + 1 < prefixSums.length; ++P, ++Q ) {
            sum = prefixSums[Q + 1] - prefixSums[P];
            average = (sum)/(double) 2;

            if (average < min) {
                min = average;
                result = P;
            }

            if ( Q + 2 < prefixSums.length ) {
                sum = prefixSums[Q + 2] - prefixSums[P];
                average = (sum)/(double) 3;

                if (average < min) {
                    min = average;
                    result = P;
                }
            }

        }

        return result;
    }
}
