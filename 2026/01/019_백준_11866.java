import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//연결리스트로 풀수 있음
//모법답안은 큐 활용 풀이임
//rear 원소를 빼고 front에 넣는 것을 반복하며 n번째일때 넣지않고 출력함으로써 구현 가능

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i + 1);
        }

        ListIterator<Integer> listIterator = linkedList.listIterator();

        sb.append('<');
        for (int i = 0; i < n; i++) {
            int nextNum = 0;
            for (int j = 0; j < k; j++) {
                if(!listIterator.hasNext()){
                    listIterator = linkedList.listIterator();
                }
                nextNum = listIterator.next();
            }
            sb.append(nextNum);
            listIterator.remove();

            if (i + 1 != n) {
                sb.append(", ");
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}