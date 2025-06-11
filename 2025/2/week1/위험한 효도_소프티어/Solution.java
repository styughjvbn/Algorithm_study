import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int result = 0;
        int timeBeforeTouch = ((int)Math.ceil(1.0*d/a)-1)*b + d%a + (d/a)*a;
        int timeAfterTouch = ((int)Math.ceil(1.0*d/b)-1)*a + d%b + (d/b)*b;
        System.out.println(timeBeforeTouch+timeAfterTouch);
    }
}
