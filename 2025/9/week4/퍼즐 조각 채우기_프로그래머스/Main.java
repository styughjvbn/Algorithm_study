import java.util.*;
import java.io.*;

class Solution {
    static int[] di = new int[]{0,1,0,-1};
    static int[] dj = new int[]{1,0,-1,0};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        HashMap<Shape, Integer> shapePool = new HashMap();
        int n,m;

        n = game_board.length;
        m = game_board[0].length;
        int[][] gameBoardVisit = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(game_board[i][j] == 0 && gameBoardVisit[i][j] == 0){
                    Shape shape = findShape(game_board, gameBoardVisit, new int[]{i,j}, 0);
                    shapePool.put(shape, shapePool.getOrDefault(shape, 0) + 1);
                }
            }
        }
        // System.out.println(shapePool);

        n = table.length;
        m = table[0].length;
        int[][] tableVisit = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(table[i][j] == 1 && tableVisit[i][j] == 0){
                    Shape shape = findShape(table, tableVisit, new int[]{i,j}, 1);
                    int count = shapePool.getOrDefault(shape, 0);
                    if(count > 0){
                        answer+=shape.size;
                        if(count>1){
                            shapePool.put(shape, count-1);
                        }else{
                            shapePool.remove(shape);
                        }
                        continue;
                    }

                    for(int k =0;k<3;k++){
                        shape = Shape.rotate(shape);
                        count = shapePool.getOrDefault(shape, 0);
                        if(count > 0){
                            answer+=shape.size;
                            if(count>1){
                                shapePool.put(shape, count-1);
                            }else{
                                shapePool.remove(shape);
                            }
                            break;
                        }
                    }
                }
            }
        }


        return answer;
    }

    public Shape findShape(int[][] array, int[][] visit, int[] startPoint, int checkFlag){
        int n = array.length;
        int m = array[0].length;
        Deque<int[]> deque = new ArrayDeque();
        deque.add(startPoint);
        visit[startPoint[0]][startPoint[1]] = 1;
        int leftUpI = startPoint[0], leftUpJ= startPoint[1], rightDownI= startPoint[0], rightDownJ= startPoint[1];
        List<int[]> pointList = new ArrayList();
        pointList.add(startPoint);
        while(!deque.isEmpty()){
            int[] curPoint = deque.poll();
            for(int k=0;k<4;k++){
                int ni = curPoint[0]+di[k];
                int nj = curPoint[1]+dj[k];
                if(0<=ni&& ni<n && 0<= nj && nj<m && visit[ni][nj]==0 && array[ni][nj]==checkFlag){
                    int[] list = new int[]{ni,nj};
                    deque.add(list);
                    pointList.add(list);
                    visit[ni][nj] = 1;
                    leftUpI = Math.min(leftUpI, ni);
                    rightDownI = Math.max(rightDownI, ni);
                    leftUpJ = Math.min(leftUpJ, nj);
                    rightDownJ = Math.max(rightDownJ, nj);
                }
            }
        }

        int rowNum = rightDownI - leftUpI + 1;
        int colNum = rightDownJ - leftUpJ + 1;
        int[][] newArray = new int[rowNum][colNum];
        int size = 0;

        for(int[] point: pointList){
            newArray[point[0]-leftUpI][point[1]-leftUpJ] = 1;
            size++;
        }

        return new Shape(rowNum, colNum, newArray, size);
    }
}

class Shape {
    int rowNum;
    int colNum;
    int[][] detail;
    int size;

    static Shape rotate(Shape shape){
        int[][] newDetail = new int[shape.colNum][shape.rowNum];
        for(int i = 0;i<shape.colNum;i++){
            for(int j = 0;j<shape.rowNum;j++){
                newDetail[i][j] = shape.detail[shape.rowNum-1-j][i];
            }
        }
        return new Shape(shape.colNum, shape.rowNum, newDetail, shape.size);
    }

    Shape(int rowNum, int colNum, int[][] detail, int size){
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.detail = detail;
        this.size = size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int[] line: detail){
            sb.append(Arrays.toString(line)).append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape other = (Shape) o;
        return Arrays.deepEquals(this.detail, other.detail);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(detail);
    }
}