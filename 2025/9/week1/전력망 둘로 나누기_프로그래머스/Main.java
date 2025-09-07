class Solution {
    public int[] solution(int n) {

        int[][] triangle = new int[n][];
        for(int i = 0;i<n;i++){
            triangle[i] = new int[i+1];
        }

        int[] di = new int[]{1, 0,-1};
        int[] dj = new int[]{0, 1,-1};
        int dir = 0;
        int curI = -1;
        int curJ = 0;
        int num = 1;
        for(int i = n;i>0;i--){
            for(int j = 0;j<i;j++){
                curI += di[dir];
                curJ += dj[dir];
                triangle[curI][curJ] = num++;
            }
            dir = (dir+1)%3;
        }

        int[] answer = new int[(int)(n*(n+1)/2)];
        int idx = 0;
        for(int[] line:triangle){
            for(int i:line){
                answer[idx++] = i;
            }
        }
        return answer;
    }
}