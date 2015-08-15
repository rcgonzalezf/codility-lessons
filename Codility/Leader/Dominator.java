// https://codility.com/demo/results/demoFUAZX6-VPY/ 100%
// https://codility.com/demo/results/demoPNG8BT-KEH/ 100%
// [1,2,3] = -1
// [1] = 0
// [1,1,-1,-1,-1,-1,2] = 4
// [3, 4, 3, 2, 3, -1, 3, 3]  = 6
// [-1,-1,2,-1,2,2] = -1
// [1,2] = -1
public class Dominator {
  public int solution(int[] A) {
        int indexOfCandidate = -1;
        int stackCounter = 0, candidate=-1, value=-1, i =0;

        for(int element: A ) {
            if (stackCounter == 0) {
                value = element;
                ++stackCounter;
                indexOfCandidate = i;
            } else {
                if (value == element) {
                    ++stackCounter;
                } else {
                    --stackCounter;
                }
            }
            ++i;
        }

        if (stackCounter > 0 ) {
            candidate = value;
        } else {
            return -1;
        }

        int countRepetitions = 0;
        for (int element: A) {
            if( element == candidate) {
                ++countRepetitions;

            }
            if(countRepetitions > (A.length / 2)) {
                return indexOfCandidate;
            }
        }
        return -1;
    }
}
