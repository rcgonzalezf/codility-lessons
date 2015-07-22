/**
See results and problem statement:

https://codility.com/demo/results/demoW36GV7-Z8P/ 81%

https://codility.com/demo/results/demoFG2EVC-GU3/ 90%

https://codility.com/demo/results/demo27Y7W6-37Y/ 100%
*/
public class FrogRiverOne {

  // (5, [1, 3, 1, 3, 2, 3, 5, 4]) = 7
  // (5,[2,1,3,5,3,2]) = -1
  // (3,[2,1,1,2,3]) = 4
  // (5, [2, 1, 3, 5, 3, 2, 4]) = 6
  // (1,[1]) = 0
  public int solution(int X, int[] A) {
   // write your code in Java SE 8
   int[] occupied = new int[A.length+1];
   int i = 0;
   int total = X;

   for (;i < A.length; ++i) {
       int index = A[i];
       if( index < occupied.length) {
           if (occupied[index] == 0) {
              --total;
              occupied[index] = 1;
           }
       }
       if (total ==0) {
           break;
       }
   }
   return total==0 ? i : -1;
 }
}
