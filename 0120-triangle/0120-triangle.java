class Solution {

    // //Recurrsion
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int m = triangle.size();
    //     int n = triangle.get(m - 1).size(); // Assuming the last row determines the number of columns

    //     return f(triangle, 0, 0, m - 1, n - 1);
    // }

    // public int f(List<List<Integer>> triangle, int r, int c, int m, int n) {
    //     if (r == m) {
    //         return triangle.get(r).get(c);
    //     }

    //     int down = triangle.get(r).get(c) + f(triangle, r + 1, c, m, n);
    //     int diagonal = triangle.get(r).get(c) + f(triangle, r + 1, c + 1, m, n);
    //     return Math.min(down, diagonal);
    // }


    
    //Memoization
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int m = triangle.size();
    //     int n = triangle.get(m - 1).size(); // Assuming the last row determines the number of columns
    //     int[][] dp= new int[m][n];
    //     for(int[] row : dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return f(triangle, 0, 0, m - 1, n - 1, dp);
    // }

    // public int f(List<List<Integer>> triangle, int r, int c, int m, int n, int[][] dp) {
    //     if (r == m) {
    //         return triangle.get(r).get(c);
    //     }

    //     if(dp[r][c] != -1){
    //         return dp[r][c];
    //     }
    //     int down = triangle.get(r).get(c) + f(triangle, r + 1, c, m, n, dp);
    //     int diagonal = triangle.get(r).get(c) + f(triangle, r + 1, c + 1, m, n, dp);
    //     return dp[r][c]= Math.min(down, diagonal);
    // }


    //Tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size(); // Assuming the last row determines the number of columns
        int[][] dp= new int[m][n];
        
        for(int i=0; i< n; i++){
            dp[m-1][i]= triangle.get(m-1).get(i);
        }

        for(int i= m-2; i>= 0; i--){
            for(int j= i; j>= 0; j--){
                int up= triangle.get(i).get(j) + dp[i+1][j];
                int upRight= triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j]= Math.min(up, upRight);
            }
        }
        return dp[0][0];
    }
}