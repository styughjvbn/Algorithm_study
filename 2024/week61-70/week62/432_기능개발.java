import java.util.*;

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList answer = new ArrayList();
        Stack<Integer> stack=new Stack<>();
        for (int i = progresses.length-1; i > -1; i--) {
            stack.push((int) Math.ceil((100-progresses[i])/(double)speeds[i]));
        }
        System.out.println(stack);
        int count=1;
        int prev_num=stack.pop();

        while (!stack.isEmpty()){
            int temp_num=stack.pop();
            if (prev_num>=temp_num){
                count++;
            }else{
                answer.add(count);
                prev_num=temp_num;
                count=1;

            }
        }
        answer.add(count);
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution temp=new Solution();
        int[] temp2= {95, 90, 99, 99, 80, 99};
        int[] temp3= {1, 1, 1, 1, 1, 1};
        System.out.println(temp.solution(temp2,temp3));
    }
}
