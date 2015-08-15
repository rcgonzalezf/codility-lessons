import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// https://codility.com/demo/results/demo97TPVG-CPP/ 100%
class Brackets {
    public static final int BALANCED = 1;
    public static final int UNBALANCED = 0;

    public int solution(String S) {
        if (S.isEmpty()) return BALANCED;

        Stack<Character> stack = new Stack<>(S.length());
        NestedValidatorUtil util = new NestedValidatorUtil();

        for (char c: S.toCharArray()) {
            if (stack.isEmpty()){
                if (util.isOpener(c)) {
                    stack.push(c);
                } else {
                    return UNBALANCED;
                }
            } else {
                if(util.isOpener(c)) {
                    stack.push(c);
                } else if(util.getOpenerForGivenCloser(c) == stack.peek()){
                    stack.pop();
                } else {
                    return UNBALANCED;
                }
            }
        }

        return stack.isEmpty() ? BALANCED : UNBALANCED;
    }

    public static class NestedValidatorUtil {
        private Map<Character, Character> language = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
            }};

        public boolean isOpener(Character c) {
            return language.values().contains(c);
        }

        public Character getOpenerForGivenCloser(Character closer) {
            return language.get(closer);
        }
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
