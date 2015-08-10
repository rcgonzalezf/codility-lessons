
// https://codility.com/demo/results/demoYRTAB2-3SJ/ 100/20 60%
public class MinAvgTwoSlice {

      public int solution(int[] A) {
         int len = A.length, result = len - 1;
         double[] minimumAverages = createMinimumAverages(A);
         double min = Double.MAX_VALUE;

         for (int i = 0; i < len; ++i ) {
             if( minimumAverages[i] < min ) {
                 min = minimumAverages[i];
                 result = i;
             }
         }

         return result;
     }

     public double[] createMinimumAverages(int[] A) {
         int len = A.length;

         int[] prefixSums = new int[len];

         for (int i = 0; i < len; ++i) {
             if(i==0) {
                 prefixSums[i] = A[i];
             } else {
                 prefixSums[i] = prefixSums[i-1] + A[i];
             }
         }

         double[] minimumAverages = new double[len];
         for ( int P = 0; P < len; ++P) {
             double minAverage = Double.MAX_VALUE;
             for (int Q = P + 1 ; Q < len; ++Q) {
                 int sum = 0;
                 if ( P == 0 ) {
                     sum = prefixSums[Q];
                 } else {
                     sum = prefixSums[Q] - prefixSums[P-1];
                 }
                 double average = (sum)/(double) ( Q - P + 1 );

                 if( minAverage > average) {
                     minAverage = average;
                 }
             }
             minimumAverages[P] = minAverage;
         }

         return minimumAverages;
     }
 }
