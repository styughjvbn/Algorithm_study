import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Trie{
    static class Node{
        Map<Character,Node> child= new HashMap<>();
        boolean isEnd;
    }
    Node root=new Node();

    void insert(String s){
        Node node=root;
        for (char c : s.toCharArray()) {
            node=node.child.computeIfAbsent(c,key->new Node());
        }
        node.isEnd=true;
    }
    boolean search(String s){
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            node=node.child.getOrDefault(s.charAt(i),null);
            if(node == null || (i!=s.length()-1 && node.isEnd)){
                return false;
            }
        }
        return node.isEnd;
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n= Integer.parseInt(br.readLine());
            Trie trie=new Trie();
            String[] temp=new String[n];
            for (int i = 0; i < n; i++) {
                temp[i]=br.readLine().trim();
                trie.insert(temp[i]);
            }
            boolean isOK=true;
            for (int i = 0; i < n; i++) {
                if(!trie.search(temp[i])){
                    isOK=false;
                    break;
                }

            }
            System.out.println(isOK?"YES":"NO");
        }
    }
}