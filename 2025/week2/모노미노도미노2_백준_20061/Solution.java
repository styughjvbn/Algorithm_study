import java.io.*;
import java.util.*;

class Solution{
    static class RunBoard{
        LinkedList<Integer> lines = new LinkedList<Integer>();
        int score = 0;
        int tileNum = 0;

        RunBoard(){}

        void addLine(int newline, boolean is2Depth){
            ListIterator<Integer> listIterator = lines.listIterator();
            int line = 0;
            while(listIterator.hasNext()){
                line = listIterator.next();
                if((line & newline) != 0){
                    listIterator.previous();
                    break;
                }
            }
            if (listIterator.hasPrevious()){
                line = listIterator.previous();
                listIterator.set(line | newline);
            }else{
                lines.addFirst(newline);
            }
            if (is2Depth){
                if (listIterator.hasPrevious()){
                    line = listIterator.previous();
                    listIterator.set(line | newline);
                }else{
                    lines.addFirst(newline);
                }
            }
        }

        int run(){
//            this.printBoard();
            score += checkGetScore();
            organizeBoard();
            return score;
        }

        int checkGetScore(){
            ListIterator<Integer> listIterator = lines.listIterator(lines.size());
            int score = 0;
            while(listIterator.hasPrevious()){
                int line = listIterator.previous();
                if (line == 0) break;
                if (line == 15) {
                    score++;
                    listIterator.remove();
                }
            }
            return score;
        }

        int checkTileNum(){
            tileNum = 0;
            lines.forEach(integer -> {
                int bit = 1;
                for (; bit<15; bit<<=1) {
                    if ((bit & integer) == bit){
                        tileNum++;
                    }
                }
            });
            return tileNum;
        }

        void organizeBoard(){
            if(lines.size()<=4) return;
            for (int i = lines.size()-4; i > 0; i--){
                lines.removeLast();
            }
        }

        void printBoard(){
            StringBuilder sb = new StringBuilder();
            for(int i = 6-lines.size(); i > 0; i--){
                sb.append("X X X X\n");
            }
            lines.forEach(integer -> {
                int bit = 1;
                for (; bit<15; bit<<=1) {
                    if ((bit & integer) == bit){
                        sb.append("O ");
                    }else{
                        sb.append("X ");
                    }
                }
                sb.append("\n");
            });
            System.out.println(sb);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        RunBoard greenBoard = new RunBoard();
        RunBoard blueBoard = new RunBoard();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (t == 1){
                greenBoard.addLine(1<<y, false);
                blueBoard.addLine(1<<x, false);
            }else if(t == 2){
                greenBoard.addLine((1<<y)+(1<<y+1), false);
                blueBoard.addLine(1<<x, true);
            } else if (t == 3) {
                greenBoard.addLine(1<<y, true);
                blueBoard.addLine((1<<x)+(1<<x+1), false);
            }
            greenBoard.run();
            blueBoard.run();

//            greenBoard.printBoard();
//            blueBoard.printBoard();
        }
        System.out.println(greenBoard.score+blueBoard.score);
        System.out.println(greenBoard.checkTileNum()+blueBoard.checkTileNum());
    }
}