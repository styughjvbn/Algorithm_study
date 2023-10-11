import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for (int i = arr.length-1; i >-1; i--) {
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            int num=stack.pop();
            if(answer.isEmpty() || answer.get(answer.size()-1)!=num){
                answer.add(num);
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution temp=new Solution();
        int[] temp2= {1,1,3,3,0,1,1};
        System.out.println(temp.solution(temp2));
    }
}
