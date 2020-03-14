class Target_number {
    public int solution(int[] numbers, int target) {

        return Dfs(numbers, 0, 0, target);
    }

    private int Dfs(int[] numbers, int node, int sum, int target){
        if(node == numbers.length){
            if(sum == target)
                return 1;
            return 0;
        }

        return Dfs(numbers, node + 1, sum + numbers[node], target)
            + Dfs(numbers, node + 1, sum - numbers[node], target);
    }
}