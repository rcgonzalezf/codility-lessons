import java.util.HashSet;

// Submission
// https://codility.com/demo/results/demoS8Y67D-HHQ/ 77
// https://codility.com/demo/results/demoB3B6NB-C9B/ 100
public class MissingInteger {

  // (-2,1) = 2
  // (2) = 1
  // (1) = 2
  // (1,2,4) = 3
  // (1,2,3) = 4
  public int solution(int[] A) {
     HashSet<Integer> temp = new HashSet<>(); // to add just positives
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
     max = Math.max(max, A.length); // taking into account arrays with random elements
     for(int i = 1; i <= max ; ++i) {
         boolean contains = temp.contains(i);
         if(!contains) {
             return i;
         }
     }
     return A.length + 1; // array is complete
 }
}
