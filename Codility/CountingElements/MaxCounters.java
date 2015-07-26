// https://codility.com/demo/results/demoD8J6M5-K3T/ 77
// https://codility.com/demo/results/demoSEJHZS-ZPR/ 100
public class MaxCounters {

  // Some testcases
  // (1,[1,2,3]) = [1]
  // (1,[1]) = [1]
  // (1,[5]) = [0]
  // (1,[1,1,1,2,3]) = 3
  // (2,[1,1,1,2,3,1]) = [4,3]
  // (5, [3, 4, 4, 5, 1, 4, 4]) = (1, 0, 1, 4, 1)
  public int[] solution(int N, int[] A) {
      int length = A.length, maxOfCounter = 0, lastUpdate = 0;
      int applyMax = N + 1;
      int result[] = new int[N];

      for (int i = 0; i < length; ++i ) {
          if(A[i] == applyMax){
              lastUpdate = maxOfCounter;
          } else if (A[i] <= N)  {
              int position = A[i]-1;
              result[position] = result[position] > lastUpdate
                                        ? result[position] + 1 : lastUpdate + 1;

              // updating the max for future use
              if(maxOfCounter <=  result[position]) {
                  maxOfCounter = result[position];
              }
          }
     }
     // updating all the values that are less than the lastUpdate to the max value
     for (int i = 0; i < N; ++i) {
         if(result[i] < lastUpdate) {
             result[i] = lastUpdate;
         }
     }

     return result;
}
}
