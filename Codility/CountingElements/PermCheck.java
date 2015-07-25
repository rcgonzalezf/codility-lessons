/**
* https://codility.com/demo/results/demoYEU94K-8FU/ 100
*/
public class PermCheck {

  public static final int NOT_PERMUTATION = 0;
  public static final int PERMUTATION = 1;
  // (4,1,3,2) = 1
  // (4,1,3) = 0
  // (1) = 1
  // () = 1
  // (2) = 0
  public int solution(int[] A) {
    // write your code in Java SE 8
    int[] mark = new int[A.length + 1];
    int counter = 0;

    for (int i = 0; i < A.length; ++i) {
        int value = A[i];
        if(value >= mark.length) {
             return NOT_PERMUTATION;
        }
        if(mark[value] == 0) {
            mark[value]=1;
            ++counter;
        } else {
            return NOT_PERMUTATION;
        }
    }

    return counter == A.length ? PERMUTATION : NOT_PERMUTATION;
  }
}
