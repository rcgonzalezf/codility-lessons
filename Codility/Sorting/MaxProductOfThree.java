import java.util.Arrays;

// https://codility.com/demo/results/demoPVG9DP-3VE/ 44
// https://codility.com/demo/results/demoRVB3K2-XJE/ 100
public class MaxProductOfThree {

  // [1,2,3,4] = 24
  public int solution(int[] sortedArray) {
       Arrays.sort(sortedArray);
       int length = sortedArray.length;
       int  P, Q, R;
       int maximumLeft = Integer.MIN_VALUE, maximumRight = Integer.MIN_VALUE;

       P = sortedArray[length - 3];
       Q = sortedArray[length - 2];
       R = sortedArray[length - 1];
       maximumRight = P * Q * R;

       P = sortedArray[0];
       Q = sortedArray[1];
       R = sortedArray[length -1];

       maximumLeft = P * Q * R;


       return maximumRight > maximumLeft ? maximumRight : maximumLeft;
   }
}
