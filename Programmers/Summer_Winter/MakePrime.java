class MakePrime {
    public int solution(int[] nums) {
        return combination(nums, 0, 0, nums.length, 3, 0);
    }

    public int combination(int[] nums, int sum, int start, int n, int r, int answer) {
        if(r == 0) {
            answer += isPrime(sum) ? 1 : 0;
            return answer;
        }

        for(int i = start ; i < n ; i++) {
            sum += nums[i];
            answer = combination(nums, sum, i+1, n, r-1, answer);
            sum -= nums[i];
        }

        return answer;
    }

    public boolean isPrime(int sum) {
        for(int i = 2 ; i <= Math.sqrt(sum) ; i++)
            if(sum % i == 0)
                return false;
        return true;
    }
}