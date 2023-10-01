import javax.swing.text.html.parser.Entity;
import java.util.*;

class Main {
    public static void main(String[] args) {
        String answer = "";
        String[] participant={"leo", "kiki", "eden"};
        String[] completion={"eden", "kiki"};
        HashMap<String,Integer> diction=new HashMap<String,Integer>();

        for (String string : participant) {
            if (diction.get(string) == null) {
                diction.put(string, 1);
            } else {
                diction.put(string, diction.get(string) + 1);
            }
        }
        for (String s : completion) {
            diction.put(s, diction.get(s) - 1);
        }
        for (Map.Entry<String, Integer> entry : diction.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey());
            }
        }
    }
}