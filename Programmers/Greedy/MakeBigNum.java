class MakeBigNum {
    public static String solution(String number, int k) {
        int index = 0;
        StringBuilder sb = new StringBuilder(number);

        while(index != sb.length() - 1 && k != 0) {
            index++;
            if(sb.charAt(index-1) < sb.charAt(index)) {
                sb.deleteCharAt(index-1);
                index = 0;
                k--;
            }
        }

        while(k != 0) {
            index = sb.length() - 1;
            sb.deleteCharAt(index);
            k--;
        }
        return sb.toString();
    }
}