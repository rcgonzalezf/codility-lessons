// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class FrogJmp {

    /*
    (1,2,1) = 1
    (2,3,1) = 1
    (2,4,1) = 2
    (2,5,2) = 2
    (2,8,80) = 1
    */
    public int  solution(int X, int Y, int D) {
         if( X == Y ) return 0;

         int result = ( Y - X ) / D;

         int applyingAnswer = X + ( D * result );

         if ( Y <= applyingAnswer ) {
             return result;
         } else {
            int difference = Y - applyingAnswer;

            if( difference <= D ) {
                result++;
            } else {
                int times = D / difference;
                result += times;
            }
         }

         return result;
    }
}
