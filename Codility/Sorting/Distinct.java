import java.util.Set;
import java.util.HashSet;

// https://codility.com/demo/results/demoVS545C-F36/  100%
public class Distinct {

    // testcases
    // (1) = 1
    // (1,2) = 2
    // (2,1,1,2,3,1) = 3
    public int solution(int[] A) {
        Set<Integer> sparseArray = new HashSet<>();
        int distinctCount= 0;

        for(int element : A ) {
            if (!sparseArray.contains(element) ) {
                sparseArray.add(element);
                ++distinctCount;
            }
        }

        return distinctCount;
    }
}
