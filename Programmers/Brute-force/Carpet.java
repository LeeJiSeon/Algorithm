class Carpet {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        for(int i = 1 ; i <= Math.sqrt(red) ; i++) {
            if(red % i == 0) {
                int w = red / i;
                int h = i;
                if((w+h)*2 + 4 == brown) {
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                    break;
                }  
            }
        }
        return answer;
    }
}