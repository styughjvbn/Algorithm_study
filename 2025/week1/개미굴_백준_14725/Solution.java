import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    static class Node{
        String word;
        HashMap<String, Node> child;

        Node(String word){
            this.word = word;
            this.child = new HashMap<>();
        }
    }
    static class Trie{
        Node root;

        Trie(){
            root = new Node("");
        }

        void insert(String[] words){
            Node cur = this.root;
            for(String word : words){
                cur.child.putIfAbsent(word, new Node(word));
                cur = cur.child.get(word);
            }
        }

        void visualize(int depth, Node node, StringBuilder sb){
            if(!node.word.isEmpty()){
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(node.word).append('\n');
            }
//            List<Node> sortedChildren = node.child.values().stream()
//                    .sorted(Comparator.comparing((Node n) -> n.word)).collect(Collectors.toList());
            List<Node> sortedChildren = new ArrayList<Node>(node.child.values());
            sortedChildren.sort(Comparator.comparing((Node n)-> n.word));
            for (Node sortedChild : sortedChildren) {
                visualize(depth+1, sortedChild, sb);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int wordNum = Integer.parseInt(st.nextToken());
            String[] words = new String[wordNum];
            for (int j = 0; j < wordNum; j++) {
                words[j] = st.nextToken();
            }
            trie.insert(words);

        }
        trie.visualize(-1, trie.root, sb);
        System.out.println(sb);
    }
}
