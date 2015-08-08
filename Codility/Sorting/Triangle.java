import java.util.Arrays;

// https://codility.com/demo/results/demo84TQBM-2QS/ 93
// https://codility.com/demo/results/demoXVA6HQ-555/ 100
public class Triangle {
    public static final int NOT_TRIANGULAR = 0;
    public static final int TRIANGULAR = 1;

    // testcases
    // (10,2,5,1,8,20) = 1
    // (10,50,5,1) = 0
    // (2147483647, 2147483647, 2147483647) = 1 for overflow
    // (1,2) = 0 two elements
    // (-1,-1,-1) = 0 negatives
    public int solution(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        for (int p = 0, q = 1, r = 2; p < (length - 2); ++p, ++q, ++r) {
            if (A[p] >= 0 && A[p] > A[r] - A[q]) {
                if (isTriangular(A[p], A[q], A[r])) {
                    return TRIANGULAR;
                }
            }
        }
        return NOT_TRIANGULAR;
    }

    public static boolean isTriangular(int P, int Q, int R) {
        return (P > R - Q) && (Q > P - R) && (P > Q - R);
    }
}
