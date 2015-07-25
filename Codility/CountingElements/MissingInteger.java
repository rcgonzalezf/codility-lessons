// Submission
// https://codility.com/demo/results/demoS8Y67D-HHQ/ 77
public class MissingInteger {

  // (-2,1) = 1
  // (2) = 1
  // (1) = 0
  // (1,2,4) = 3
  public int solution(int[] A) {
      // write your code in Java SE 8
      int minimalPositiveInteger = 1;

      HashSet<Integer> temp = new HashSet<>();
      int max = 1;

      for (int i =0; i < A.length; ++i) {
          int current = A[i];

          if (current < 0 ) {
              continue;
          } else {
              temp.add(current);

              if( max <= current) {
                  max = current;
              }
          }
      }

      max = Math.max(max, A.length);

      for(int i = 1; i <= max ; ++i) {
          boolean contains = temp.contains(i);
          if(!contains) {
              return i;
          }
      }

      return minimalPositiveInteger;
  }
}
