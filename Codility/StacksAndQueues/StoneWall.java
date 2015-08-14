import java.util.ArrayList;
import java.util.List;

// https://codility.com/demo/results/demoX7Z9X3-HSB/ 100%
public class StoneWall {

      public int solution(int[] H) {
          int len = H.length;
          Stack<Integer> stack = new Stack<>(len);
          int blockCounter = 0;

          for (int i = 0; i < len; ++i) {
              int element = H[i];
              if (stack.isEmpty()) {
                  stack.push(element);
                  ++blockCounter;
              } else {
                  while (!stack.isEmpty() && stack.peek() > element) {
                      stack.pop();
                  }
                  if (!stack.isEmpty() && stack.peek() == element) {
                     continue;
                  } else {
                      stack.push(element);
                      ++blockCounter;
                  }
              }
          }

          return blockCounter;
      }

      public static class Stack<T> {
          public List<T> stack;

          public Stack(int capacity) {
              stack = new ArrayList<>(capacity);
          }

          public void push(T item) {
              stack.add(item);
          }

          public T pop() {
              T item = peek();
              stack.remove(stack.size() - 1);
              return item;
          }

          public T peek() {
              int position = stack.size();
              T item = stack.get(position - 1);
              return item;
          }

          public boolean isEmpty() {
              return stack.isEmpty();
          }
      }
  }
