import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack=new Stack<Character>();

        for (char c : s.toCharArray()) {
            if(c=='('){
                stack.push('(');
            }else{
                if(stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return answer;
        else
            return false;
    }
}

class Main {
    public static void main(String[] args) {
        Solution temp=new Solution();
        int[] temp2= {1,1,3,3,0,1,1};
        System.out.println(temp.solution("(())()"));
    }
}
