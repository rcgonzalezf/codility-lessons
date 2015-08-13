// https://codility.com/demo/results/demoBW9USM-AMD/ 100%
public class Nesting {
    public static final int BALANCED = 1;
    public static final int UNBALANCED = 0;

    public int solution(String S) {
        if (S.length() % 2 != 0) {
            return UNBALANCED;
        }
        int counter = 0, increment = 1;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                increment = increment > 0 ? increment : increment * -1;
            } else if (c == ')') {
                increment = increment < 0 ? increment : increment * -1;
            }
            counter += increment;
            if (counter < 0) {
                return UNBALANCED;
            }
        }

        return counter == 0 ? BALANCED : UNBALANCED;
    }
}
