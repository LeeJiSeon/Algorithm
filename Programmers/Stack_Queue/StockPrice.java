class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length - 1 ; i++)
            for(int j = i + 1 ; j < prices.length ; j++) {
                if(prices[i] <= prices[j])
                    answer[i]++;
                else {
                    answer[i]++;
                    break;
                }
            }
        return answer;
    }
}
//[1,2,3,2,3]
//[4,3,1,1,0]

//[3, 1]
//[1, 0]