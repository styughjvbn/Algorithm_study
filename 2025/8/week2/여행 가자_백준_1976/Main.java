public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        int a,b,c,d;
        for (int i = 2; i <= 100; i++) {
            a = i*i*i;
            for (int j = 2; j <= i; j++) {
                b = j*j*j;
                for (int k = j; k <= i; k++) {
                    c = k*k*k;
                    for (int l = k; l <= i; l++) {
                        d = l*l*l;
                        if( a < b+c+d){
                            break;
                        }
                        if( a == b+c+d){
                            sb.append("Cube = ").append(i).append(", Triple = (").append(j).append(',').append(k).append(',').append(l).append(")\n");
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}