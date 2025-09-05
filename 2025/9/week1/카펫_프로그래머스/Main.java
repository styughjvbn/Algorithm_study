class Solution {
    public int[] solution(int brown, int yellow) {
        int a,b,c;
        c = yellow;
        a = 1;
        b = -(brown/2 - 2);
        double D = b * b - 4 * a * c;
        double root1 = (-b + Math.sqrt(D)) / (2 * a);
        double root2 = (-b - Math.sqrt(D)) / (2 * a);
        int r1 = (int)Math.round(root1);
        int r2 = (int)Math.round(root2);
        int row = Math.max(r1, r2) + 2;
        int column = Math.min(r1, r2) + 2;

        return new int[]{row, column};
    }
}