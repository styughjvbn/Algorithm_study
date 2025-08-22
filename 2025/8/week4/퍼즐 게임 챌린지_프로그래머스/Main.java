class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = 100_000L;

        while(left < right){
            long mid = (left + right) >> 1;

            if(isImPossible(diffs, times, mid, limit)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return (int) left;
    }

    private static boolean isImPossible(int[] diffs, int[] times, long level, long limit){
        long tmp = (long) times[0];

        for(int i=1; i<diffs.length; i++){
            if(diffs[i] > level){
                tmp += (diffs[i] - level) * (times[i-1] + times[i]);
            }
            tmp += times[i];
        }
        return limit < tmp;
    }
}