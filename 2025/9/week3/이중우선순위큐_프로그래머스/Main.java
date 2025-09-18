import java.util.*;
import java.io.*;

class Solution {
    static StringTokenizer st;
    public int[] solution(String[] operations) {
        PriorityQueue<Number> maxPQ = new PriorityQueue<>((a,b)->b.num-a.num);
        PriorityQueue<Number> minPQ = new PriorityQueue<>((a,b)->a.num-b.num);

        int[] answer = {};
        for(String operation:operations){
            st = new StringTokenizer(operation, " ");
            String operator = st.nextToken();
            int operand = Integer.parseInt(st.nextToken());
            if(operator.charAt(0) == 'I'){
                Number number = new Number(operand);
                maxPQ.add(number);
                minPQ.add(number);
            }else{
                if(operand == 1){
                    while(!maxPQ.isEmpty()){
                        Number maxNum = maxPQ.poll();
                        if(!maxNum.isDeleted){
                            maxNum.isDeleted = true;
                            break;
                        };
                    }
                }else{
                    while(!minPQ.isEmpty()){
                        Number minNum = minPQ.poll();
                        if(!minNum.isDeleted){
                            minNum.isDeleted = true;
                            break;
                        };
                    }
                }
            }

        }
        int maxRes = 0;
        int minRes = 0;
        while(!maxPQ.isEmpty()){
            Number maxNum = maxPQ.poll();
            if(!maxNum.isDeleted){
                maxRes = maxNum.num;
                break;
            };
        }
        while(!minPQ.isEmpty()){
            Number minNum = minPQ.poll();
            if(!minNum.isDeleted){
                minRes = minNum.num;
                break;
            };
        }

        return new int[]{maxRes,minRes};
    }
}

class Number{
    int num;
    boolean isDeleted = false;

    Number(int num){
        this.num = num;
    }

    public String toString(){
        return " "+num+" "+isDeleted;
    }
}