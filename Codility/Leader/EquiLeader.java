
// https://codility.com/demo/results/demoZSME5G-RXN/ 100

class Solution {
  public int solution(int[] A) {
     Leader leader = getLeader(A);
     if ( leader == null ) { return 0; }
     int equileaders = 0, leaderCounter =0, len = A.length;

     for(int i=0; i < len ; ++i) {
         if(A[i] == leader.value) {
             ++leaderCounter;
         }
         if ((leaderCounter > (i+1)/2 && (leader.ocurrences - leaderCounter)>(len-1-i)/2) ) {
             ++equileaders;
         }
     }
     return equileaders;
 }

 public static class Leader {
     int ocurrences;
     int value;

     public Leader(int value, int ocurrences) {
         this.value = value;
         this.ocurrences = ocurrences;
     }
 }

 public Leader getLeader(int[] A) {
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
         return null;
     }

     int countRepetitions = 0;
     for (int element: A) {
         if( element == candidate) {
             ++countRepetitions;
         }
     }

     if(countRepetitions > (A.length / 2)) {
         return new Leader(candidate, countRepetitions);
     }
     return null;
 }
}
