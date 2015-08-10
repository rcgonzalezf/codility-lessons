// https://codility.com/demo/results/demoYT35S4-3SX/ 62%
// https://codility.com/demo/results/demoP2PVHP-MN8/ 75 %
// https://codility.com/demo/results/demoJFB5EV-EG8/ 100%
public class GenomicRangeQuery {

    // testCases
    //('A',[0],[0]) = [1]
    //('ACCCACCCA',[1,1,5],[3,4,7]) = [2,1,2]
    // ('AC',[0,0,1],[0,1,1]) = [1,1,2]
    // ('AAGT',[0,2,2,3],[0,2,3,3]) = [1,3,3,4]
    // ('TTTATTTT', [0, 0, 3, 4], [2, 3, 7, 7]) = [4,1,1,4]
    private ImpactFactorHolder[] mHolder;
    private static final int A = 0, C = 1, G = 2, T = 3;

    public int[] solution(String S, int[] P, int[] Q) {
        mHolder = createImpactHolderArray(S);

        int queriesLength = P.length;
        int[] result = new int[queriesLength];

        for (int i = 0; i < queriesLength; ++i) {
            int value = 0;
            if (P[i] == Q[i]) {
                value = lookupValueForIndex(S.charAt(P[i])) + 1;
            } else {
                value = calculateMinImpactFactor(P[i], Q[i]);
            }
            result[i] = value;
        }
        return result;

    }

    public int calculateMinImpactFactor(int P, int Q) {
        int minImpactFactor = 3;

        for (int nucleotide = A; nucleotide <= T; ++nucleotide) {
            int qValue = mHolder[nucleotide].mOcurrencesSum[Q];
            int pValue = mHolder[nucleotide].mOcurrencesSum[P];
            // handling special cases when the less value is assigned on the P index
            if (P - 1 >= 0) {
                pValue = mHolder[nucleotide].mOcurrencesSum[P - 1] == 0 ? 0 : pValue;
            } else if (P == 0) {
                pValue = mHolder[nucleotide].mOcurrencesSum[P] == 1 ? 0 : pValue;
            }

            if (qValue - pValue > 0) {
                minImpactFactor = nucleotide;
                break;
            }
        }
        return minImpactFactor + 1;
    }

    public int lookupValueForIndex(char nucleotide) {
        int value = 0;
        switch (nucleotide) {
            case 'A':
                value = A;
                break;
            case 'C':
                value = C;
                break;
            case 'G':
                value = G;
                break;
            case 'T':
                value = T;
                break;
            default:
                break;
        }
        return value;
    }

    public ImpactFactorHolder[] createImpactHolderArray(String S) {
        int length = S.length();
        ImpactFactorHolder[] holder = new ImpactFactorHolder[4];
        holder[A] = new ImpactFactorHolder(1, 'A', length);
        holder[C] = new ImpactFactorHolder(2, 'C', length);
        holder[G] = new ImpactFactorHolder(3, 'G', length);
        holder[T] = new ImpactFactorHolder(4, 'T', length);
        int i = 0;
        for (char c : S.toCharArray()) {
            int nucleotide = lookupValueForIndex(c);
            ++holder[nucleotide].mAcum;
            holder[nucleotide].mOcurrencesSum[i] = holder[nucleotide].mAcum;
            holder[A].mOcurrencesSum[i] = holder[A].mAcum;
            holder[C].mOcurrencesSum[i] = holder[C].mAcum;
            holder[G].mOcurrencesSum[i] = holder[G].mAcum;
            holder[T].mOcurrencesSum[i] = holder[T].mAcum;
            ++i;
        }

        return holder;
    }

    private static class ImpactFactorHolder {
        public ImpactFactorHolder(int impactFactor, char nucleotide, int length) {
            mImpactFactor = impactFactor;
            mNucleotide = nucleotide;
            mOcurrencesSum = new int[length];
            mAcum = 0;
        }

        int mImpactFactor;
        char mNucleotide;
        int[] mOcurrencesSum;
        int mAcum;
    }
}
