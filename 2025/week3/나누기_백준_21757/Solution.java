import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] numSeq;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numSeq = new int[n];
        for (int i = 0; i < n; i++) {
            numSeq[i] = Integer.parseInt(st.nextToken());
        }
        long[] leftPrefixSum = new long[n];
        leftPrefixSum[0] = numSeq[0];
        long[] rightPrefixSum = new long[n];
        rightPrefixSum[0] = numSeq[n - 1];
        for (int i = 1; i < n; i++) {
            leftPrefixSum[i] = leftPrefixSum[i - 1] + numSeq[i];
            rightPrefixSum[i] = rightPrefixSum[i-1] + numSeq[n-1-i];
        }
        HashMap<Long, List<Integer>> leftPrefixSumHash = new HashMap<>();
        HashMap<Long, List<Integer>> rightPrefixSumHash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> indexList = leftPrefixSumHash.computeIfAbsent(leftPrefixSum[i],k -> new ArrayList<>());
            indexList.add(i);
            indexList = rightPrefixSumHash.computeIfAbsent(rightPrefixSum[i],k -> new ArrayList<>());
            indexList.add(n-1-i);
        }
//        System.out.println(leftPrefixSumHash);
//        System.out.println(rightPrefixSumHash);
        long result = 0;
        for (int i = 1; i < n-2; i++) {
            if((leftPrefixSum[i] == leftPrefixSum[n-1]-leftPrefixSum[i]) && leftPrefixSum[i]%2 == 0){
//                System.out.println("i = "+i);
//                System.out.println(leftPrefixSum[i]);
                List<Integer> indexList = leftPrefixSumHash.get(leftPrefixSum[i]/2);
                long leftCount = 0;
                if(indexList != null){
//                    for (Integer index : indexList) {
//                        if (index >= i)break;
//                        leftCount++;
//                    }
//                    System.out.println("JJJ");
//                    System.out.println(leftCount);
                    long tempIndex = Collections.binarySearch(indexList,i-1);
                    if (tempIndex < 0)
                        tempIndex = (tempIndex+1)*-1;
                    else
                        tempIndex = tempIndex +1;
                    leftCount = tempIndex;
//                    System.out.println(Collections.binarySearch(indexList,i-1));
                }

                indexList = rightPrefixSumHash.get(leftPrefixSum[i]/2);
                long rightCount = 0;
                if(indexList != null){
//                    for (Integer index : indexList) {
//                        if (index <= i + 1)break;
//                        rightCount++;
//                    }
//                    System.out.println("KKK");
//                    System.out.println(rightCount);
                    long tempIndex = Collections.binarySearch(indexList,i+1, Comparator.reverseOrder());
//                    System.out.println("fd "+tempIndex);
                    if (tempIndex < 0)
                        tempIndex = (tempIndex+1)*-1;
//                    else
//                        tempIndex = tempIndex ;
                    rightCount = tempIndex;
                }

//                System.out.println("싀발"+leftCount+" "+rightCount);
//                System.out.println(leftCount * rightCount);
                result += leftCount * rightCount;
            }
        }
        System.out.println(result);
    }
}