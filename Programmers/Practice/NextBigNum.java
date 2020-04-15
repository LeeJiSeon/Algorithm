//Intger.bitcount() : 이진 수의 1의 개수
class NextBigNum {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            String bin = Integer.toBinaryString(n);
            bin = bin.replace("0", "");
            for(int i = n + 1 ; ; i++) {
                String com = Integer.toBinaryString(i);
                if(bin.equals(com.replace("0", ""))) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
      }
}