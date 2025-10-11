import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[] line = bufferedReader.readLine().toCharArray();
        char[] bomb = bufferedReader.readLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> tempStack = new ArrayDeque<>();
        char triggerChar = bomb[bomb.length-1];
        for (int i = 0; i < line.length; i++) {
            stack.push(line[i]);
            if(stack.size() >= bomb.length && stack.peekFirst() == triggerChar){
                for (int j = bomb.length - 1; j >= 0 ; j--) {
                    char c = stack.pop();
                    tempStack.push(c);
                    if(c != bomb[j]){
                        while(!tempStack.isEmpty()){
                            stack.push(tempStack.pop());
                        }
                        break;
                    }
                }
                tempStack.clear();
            }
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else {
            while(!stack.isEmpty()){
                sb.append(stack.pollLast());
            }
            System.out.println(sb);
        }
    }
}