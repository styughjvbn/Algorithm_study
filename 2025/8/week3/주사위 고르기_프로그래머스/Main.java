import java.util.*;

class Solution {
    int[] combination;
    int n;
    int[][] dice;
    List<int[]> diceCombinations = new ArrayList();
    List<int[]> diceCombNums = new ArrayList();
    List<int[]> diceCombinationsPrefix = new ArrayList();

    public int[] solution(int[][] dice) {
        this.dice = dice;
        n = dice.length;
        combination = new int[n/2];
        dfs(0,0);
        prefixSum();
        int len = diceCombinations.size();
        int max = 0;
        int maxIdx = 0;
        for( int i = 0;i<len;i++){
            int[] arrA = diceCombinations.get(i);
            int[] arrB = diceCombinationsPrefix.get(len - i -1);
            int tempMax = 0;
            for(int j = 1; j<arrA.length;j++){
                if(arrA[j]!=0){
                    tempMax+=arrA[j]*arrB[j-1];
                }
            }
            if(max < tempMax){
                maxIdx = i;
            }
            max = Math.max(max, tempMax);
        }
        // System.out.println(max);
        int[] ansArr = diceCombNums.get(maxIdx);
        Arrays.sort(ansArr);
        // System.out.println(Arrays.toString(ansArr));
        for(int i = 0;i<ansArr.length;i++){
            ansArr[i]++;
        }
        return ansArr;
    }

    public void prefixSum(){
        for(int i =0;i<diceCombinations.size();i++){
            int[] arr = diceCombinations.get(i);
            int[] newArr = Arrays.copyOf(arr, arr.length);
            for(int j = 1;j<arr.length;j++){
                newArr[j] += newArr[j-1];
            }
            diceCombinationsPrefix.add(newArr);
        }
    }

    public void dfs(int depth, int a){
        if(depth >=n/2){
            // System.out.println(Arrays.toString(combination));
            int[] comb =Arrays.copyOf(combination, combination.length);
            diceCombNums.add(comb);
            diceCombinations.add(makeNumCase());
            return;
        }
        for(int i = a;i<n;i++){
            combination[depth] = i;
            dfs(depth+1, i+1);
        }
    }

    public int[] makeNumCase(){
        int diceCount = n/2;
        int[] numCases = new int[100*diceCount+1];
        diceDfs(0, 0, numCases);
        // System.out.println(Arrays.toString(numCases));
        return numCases;
    }

    public void diceDfs(int depth, int sum, int[] numCases){
        if(depth>=n/2){
            numCases[sum]++;
            return;
        }

        for(int i =0;i<6;i++){
            diceDfs(depth+1, sum+dice[combination[depth]][i], numCases);
        }
    }
}