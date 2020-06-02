class MatrixMul {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int h = arr1.length;
        int w = arr2[0].length;
        int[][] answer = new int[h][w];
        for(int i = 0 ; i < h ; i++) {
            for(int j = 0 ; j < w ; j++) {
                for(int k = 0 ; k < arr2.length ; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}