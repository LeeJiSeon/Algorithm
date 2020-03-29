import java.util.Arrays;
class Min_Max_other {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for(int i = 0 ; i < str.length ; i++)
            arr[i] = Integer.parseInt(str[i]);
        Arrays.sort(arr);
        return arr[0] + " " + arr[arr.length-1];
    }
}