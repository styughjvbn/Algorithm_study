class Solution {
    int n;
    int[][] q;
    int[] ans;
    int[] code;
    int answer;

    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        this.n = n;
        this.q = q;
        this.ans = ans;
        code = new int[n+1];
        dfs(0,1);
        return answer;
    }

    public void dfs(int depth, int a){
        if(depth >=5){
            if(check())answer++;
            return;
        }

        for(int i =a ;i<=n;i++){
            code[i] = 1;
            dfs(depth+1, i+1);
            code[i] = 0;
        }
    }

    public boolean check(){
        for(int i = 0;i<q.length;i++){
            int[] qSeq = q[i];
            int equalCount = 0;
            for(int num: qSeq){
                if(code[num]==1){
                    equalCount++;
                }
            }
            if(equalCount!=ans[i]){
                return false;
            }
        }
        return true;
    }
}