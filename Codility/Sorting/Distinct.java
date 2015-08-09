import java.util.Set;
import java.util.HashSet;
import java.util.BitSet;

// https://codility.com/demo/results/demoVS545C-F36/  100%
// https://codility.com/demo/results/demoX7MSFZ-JMB/ 100%
// https://codility.com/demo/results/demoMTWUSD-S9M/ 100%
public class Distinct {

    // testcases
    // [0] = 1
    // [1,2] = 2
    // [2,1,1,2,3,1] = 3
    // [-1,0,1,1] = 3
    // https://codility.com/demo/results/demoN57YUC-G9Z/ 100%
    public int solution(int[] A) {
        // first part for negatives, second part for positives and adding 1
        // to count the zero as part of the positives section
        int offset = 1_000_000;
        BitSet bitSet = new BitSet( (offset * 2) + 1 );

        for (int element : A ) {
            int index = element >= 0 ? offset + element : (element * -1);
            bitSet.set(index);
        }

        return bitSet.cardinality();
    }

    // If we have collitions this is the worst it can lead
    // to a O N^2 performance a O N space
    public int solutionWithSetPossiblyWorst(int[] A) {
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

    public int solutionWithoutSet(int[] A) {
        int length = A.length;
        int inputLimit = 1000000;
        int[] positives = new int[inputLimit];
        int[] negatives = new int[inputLimit]; // should be length - 1 not counting zero

        for (int element : A) {
            if ( element >=0 ) {
                ++positives[element];
            } else {
                int abs = element * -1;
                ++negatives[abs];
            }
        }


        int countDistincts = 0;

        for (int i = 0; i < inputLimit; ++i) {
            if ( positives[i] != 0 ) {
                ++countDistincts;
            }

            if ( negatives[i] != 0 ) {
                ++countDistincts;
            }

            if ( countDistincts == length ) {
                break; // no need to compare all elements
            }
        }

        return countDistincts;
    }

    public int solutionWithoutSetCountUntilInputLength(int[] A) {
       int length = A.length;
       int inputLimit = 1000000;
       int[] positives = new int[inputLimit];
       int[] negatives = new int[inputLimit]; // should be length - 1 not counting zero

       for (int element : A) {
           if ( element >=0 ) {
               ++positives[element];
           } else {
               int abs = element * -1;
               ++negatives[abs];
           }
       }

       int countDistincts = 0;

       for (int i: A) {
           if (i >= 0 ) {
               if ( positives[i] >= 1 ) {
                   ++countDistincts;
                   positives[i] = 0;
               }
           } else {
               if ( negatives[i * -1] >= 1 ) {
                   ++countDistincts;
                   negatives[i * -1] = 0;
               }
           }
       }
       return countDistincts ;
   }

}
