// https://codility.com/demo/results/demoQVUTC5-CEJ/ 75
// https://codility.com/demo/results/demo7B54KC-WYJ/ 87
// https://codility.com/demo/results/demoWFBKU8-SNV/ 100
public class CountDiv {
  // Test cases
  // [1,1,1] = 1
  // [0,99,2] = 50
  // [0, 100, 3] = 34
  // [11,345,17] = 20
  // [10,10,5] = 1
  // [3, 6, 2] = 2
  // [6,11,2] = 3
  // [16,29,7] = 2
  // [1,2,1] = 2
  public int solution(int A, int B, int K) {
    int offsetForLeftRange = 0;
    if ( A % K == 0) { ++offsetForLeftRange; }

    return  (B/K) - (A /K) + offsetForLeftRange;
  }
}
