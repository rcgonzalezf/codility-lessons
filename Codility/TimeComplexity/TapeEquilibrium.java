// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.\
*/

public class TapeEquilibrium {
   public int solution84percent(int[] A) {
        // write your code in Java SE 8
        // sum everything and save the value of the total sum
        // subtotal is the sum from 0...N
        // | {total - subTotal} - |

        int total =0, result, difference, subtotal = 0;

        for (int i = 0; i < A.length; ++i) {
            total += A[i];
        }

        result = total < 0? total * -1 : total;

        for (int j=0; j < A.length - 1; ++j) {
            subtotal += A[j];

            int op1, op2;

            op1 = subtotal;
            op2 = total - subtotal;

            difference = op1 - op2;

            difference = difference < 0 ? ( difference * (-1)) : difference;

            if (difference <= result) {
                result = difference;
            }
        }

        return result;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;

        int P = 1;
        int head = A[0];
        int tail = 0;
        for ( int i = P; i < N; ++i ) {
            tail += A[i];
        }
         int difference = Math.abs(head - tail);

         for( ; P < N - 1; ++P ) {
             head += A[P];
             tail -= A[P];

             int newDifference = Math.abs(head - tail);

             if( newDifference <= difference ) {
                 difference = newDifference;
             }
         }

         return difference;
    }
}
}
