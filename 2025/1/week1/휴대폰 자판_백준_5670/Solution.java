import java.io.*;
import java.util.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        while(true){
            int n = 0;
            try{
                String input = br.readLine();
                n = Integer.parseInt(input);
            }catch(Exception e){
                break;
            }
            Trie trie = new Trie();
            for (int i = 0; i < n; i++) {
                trie.insert(br.readLine().trim());
            }
            System.out.printf("%.02f\n",trie.getClickAverage(n));
        }
    }
}

class Node{
    Character charcter;
    HashMap<Character, Node> child;
    boolean endOfWord;

    Node(char charcter){
        child = new HashMap<>();
        endOfWord = false;
        this.charcter = charcter;
    }
}
class Trie{
    Node root;

    public Trie(){
        root = new Node(' ');
    }

    public void insert(String word){
        Node curNode = root;
        char[] charOfWord = word.toCharArray();
        for (char curChar : charOfWord) {
            if (!curNode.child.containsKey(curChar)) {
                curNode.child.put(curChar, new Node(curChar));
            }
            curNode = curNode.child.get(curChar);
        }
        curNode.endOfWord = true;
    }

    public float getClickAverage(int n){
        Collection<Node> childs = root.child.values();
        int total = 0;
        for (Node node : childs) {
            total+=calcClickCount(node, 1);
        }
        return (float) total /n;
    }

    private int calcClickCount(Node node, int click){
        int totalClickCount = 0;
        Collection<Node> curChilds = node.child.values();
        for (Node childNode : curChilds) {
            if(node.child.size() > 1 || node.endOfWord){
                totalClickCount += calcClickCount(childNode, click+1);
            }else{
                totalClickCount += calcClickCount(childNode, click);
            }
        }

        if(node.endOfWord){
            totalClickCount += click;
        }
        return totalClickCount;
    }
}