class Solution {
    public int solution(int[] arr) {
        for(int i = 1;i<arr.length;i++){
            int numA = arr[i-1];
            int numB = arr[i];
            int lcm = numA * numB /gcd(numA, numB);
            arr[i] = lcm;
        }

        return arr[arr.length-1];
    }

    public int gcd(int a, int b){
        int c;
        while(true){
            c = a%b;
            if(c == 0) return b;
            a = b;
            b = c;
        }
    }
}