// https://codility.com/demo/results/demo7MXC2N-RJJ/ 75% 75/75
// https://codility.com/demo/results/demo967MY4-J2X/ 100%
import java.util.Stack;

public class Fish {

    private static final int UPSTREAM = 0;
    private static final int DOWNSTREAM = 1;

    // Sample input
    // ([2,3],[1,0]) = 1
    // ([4, 3, 2, 1, 5], [0, 1, 0, 0, 0])  = 2
    public int solution(int[] A, int[] B) {
        Stack<Fish> stack = new Stack<>();

        for(int f = 0; f < A.length; ++f) {
            Fish currentFish = new Fish(A[f],B[f]);

            if (stack.isEmpty()) {
                stack.push(currentFish);
            } else {
                Fish previousFish = stack.peek();
                if(previousFish.direction == DOWNSTREAM && currentFish.direction == UPSTREAM) {
                    boolean currentFishAlive = true;
                    while (!stack.isEmpty() && stack.peek().direction != currentFish.direction) {
                        if (stack.peek().size < currentFish.size) {
                            stack.pop(); // previous fish eaten
                        } else {
                            currentFishAlive = false;
                            break;
                        }
                    }
                    if (currentFishAlive) { stack.push(currentFish); }
                } else { // same direction or don't meet P < Q, but no B[P] = 1, B[Q] = 0
                    stack.push(currentFish);
                }
            }
        }

        return stack.size();
    }

    public static class Fish {
        public int direction;
        public int size;
        public Fish(int size, int direction) {
            this.size = size;
            this.direction = direction;
        }
    }
}
