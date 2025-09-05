class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][2];
        int cur = 0;
        int prev = 1;
        dp[0][prev] = triangle[0][0];
        for(int k = 1; k<triangle.length;k++){
            int[] line = triangle[k];
            dp[0][cur] = line[0] + dp[0][prev];
            for(int i = 1;i<line.length-1;i++){
                dp[i][cur] = line[i] + Math.max(dp[i-1][prev], dp[i][prev]);
            }
            dp[line.length-1][cur] = line[line.length-1] + dp[line.length-2][prev];
            prev = cur;
            cur = (cur + 1)%2;
        }
        for(int i = 0; i<triangle.length;i++){
            if(answer < dp[i][prev])answer = dp[i][prev];
        }
        return answer;
    }
}