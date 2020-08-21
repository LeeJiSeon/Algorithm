class Solution {
    public long LongJump(int n) {
        if(n == 1)
            return 1;
        long[] jumping = new long[n];
        jumping[0] = 1;
        jumping[1] = 2;
        for(int i = 2; i < n ; i++) {
            jumping[i] = (jumping[i-1] + jumping[i-2]) % 1234567;
        }
        return jumping[n-1];
    }
}
