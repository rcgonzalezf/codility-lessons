/**
See results and problem statement:
https://codility.com/demo/results/demoT3XU3M-RTE/
*/
public class FrogRiverOne {

  // (5, [1, 3, 1, 3, 2, 3, 5, 4]) = 7
  // (5,[2,1,3,5,3,2]) = -1
  // (3,[2,1,1,2,3]) = 4
  public int solution(int X, int[] A) {
    // write your code in Java SE 8

      int[] occupied = new int[A.length+1];

      for (int i = 0; i < A.length; ++i) {

          if(A[i] <= X) {
              occupied[A[i]] = ++occupied[A[i]];
          }
          if(A[i] == X) {
              break;
          }
      }

      int accum = 0;
      for (int i = 1; i <= X; ++i) {
          if(occupied[i] != 0 ) {
              accum += occupied[i];
          } else {
              return -1;
          }
      }
      return accum - 1;
  }
}
