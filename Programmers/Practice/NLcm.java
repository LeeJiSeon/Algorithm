class NLcm {
    public int solution(int[] arr) {
        int a = arr[0];
        int b, g;
        for(int i = 1 ; i < arr.length ; i++) {
            b = arr[i];
            g = gcd(Math.max(a, b), Math.min(a, b));
            a = a * b / g;
        }
        return a;
    }

    public int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return gcd(b, a%b);
    }
}