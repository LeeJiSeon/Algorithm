import java.util.HashSet;

class Pocketmon {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        return Math.min(nums.length/2, set.size());
    }
}