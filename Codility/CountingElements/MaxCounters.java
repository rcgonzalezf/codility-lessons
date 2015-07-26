// https://codility.com/demo/results/demoD8J6M5-K3T/ 77
// https://codility.com/demo/results/demoSEJHZS-ZPR/ 100
public class MaxCounters {

  // (1,[1,2,3]) = [1]
  // (1,[1]) = [1]
  // (1,[5]) = [0]
  // (1,[1,1,1,2,3]) = 3
  // (2,[1,1,1,2,3,1]) = [4,3]
  // (5, [3, 4, 4, 5, 1, 4, 4]) = (1, 0, 1, 4, 1)
  public int[] solution(int N, int[] A) {
          int length = A.length, maxOfCounter = 0;
          int applyMax = N + 1;
          int result[] = new int[N];

          for (int i = 0; i < length; ++i ) {
              if (A[i] <= N) {
                  result[A[i]-1] = result[A[i]-1] + 1;

                  if(maxOfCounter <=  result[A[i]-1]) {
                      maxOfCounter = result[A[i]-1];
                  }
              } else if(A[i] == applyMax){
                  for (int j = 0; j < result.length; ++j) {
                   result[j] = maxOfCounter;
                  }
              }
          }

          return result;
  }
}
