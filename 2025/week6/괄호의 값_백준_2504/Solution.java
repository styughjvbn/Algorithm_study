import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution{
    static char[] parenthesesString;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        parenthesesString = br.readLine().trim().toCharArray();
        Stack<String> stack = new Stack<>();

        for(char parentheses: parenthesesString){
            if(parentheses == '(' || parentheses == '['){
                stack.push(String.valueOf(parentheses));
            }else{
                if (stack.isEmpty()){
                    System.out.println(0);
                    System.exit(0);
                }else{
                    if (parentheses == ')'){
                        int acc = 0;
                        while (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("[")){
                            acc += Integer.parseInt(stack.pop());
                        }
                        if ( !stack.isEmpty() && stack.pop().equals("(")){
                            stack.push(String.valueOf((acc==0?1:acc)*2));
                        } else{
                            System.out.println(0);
                            System.exit(0);
                        }
                    }
                    if (parentheses == ']'){
                        int acc = 0;
                        while (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("[")){
                            acc += Integer.parseInt(stack.pop());
                        }
                        if ( !stack.isEmpty() && stack.pop().equals("[")){
                            stack.push(String.valueOf((acc==0?1:acc)*3));
                        } else{
                            System.out.println(0);
                            System.exit(0);
                        }
                    }
                }
            }
//            System.out.println(stack);
        }
        int result = 0;
//        System.out.println(stack);
        while(!stack.isEmpty()){
            if( stack.peek().equals("(") || stack.peek().equals("[")){
                System.out.println(0);
                System.exit(0);
            }
            result+=Integer.parseInt(stack.pop());
        }
        System.out.println(result);
    }
}