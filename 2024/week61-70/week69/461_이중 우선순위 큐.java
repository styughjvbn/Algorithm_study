import java.util.*;
import java.io.*;
class data{
    int num;
    int maxHeapIndex;
    int minHeapIndex;

    public data(int num, int maxHeapIndex, int minHeapIndex){
        this.num=num;
        this.maxHeapIndex=maxHeapIndex;
        this.minHeapIndex=minHeapIndex;
    }
}
class myPQ{
    data[] array;
    int len;
    boolean isMin;
    public myPQ(boolean isMin){
        array=new data[1000001];
        len=0;
        this.isMin=isMin;
    }

    public void push(data a) {
        len++;
        if(isMin){
            a.minHeapIndex=len;
        }else{
            a.maxHeapIndex=len;
        }
        array[len]=a;
        toUp(len);
    }
    public data pop() {
        data value;
        if(!isEmpty()) {
            value=array[1];
            sawp(1,len);
            array[len]=null;
            len-=1;
            toDown(1);
            return value;
        }
        throw new ArrayIndexOutOfBoundsException("sdsd");
    }
    public boolean isEmpty() {
        return len == 0;
    }

    public void toDown(int index) {
        if(index*2>len) {
            return;
        }else {
            int myNum=array[index].num;
            int nextIndex=0;
            int nextIndexValue=myNum;
            if(isMin){
                if(index*2<=len && myNum>array[index*2].num) {
                    nextIndex=index*2;
                    nextIndexValue=array[index*2].num;
                }
                if(index*2+1<=len && myNum>array[index*2+1].num) {
                    if(nextIndexValue>array[index*2+1].num) {
                        nextIndex=index*2+1;
                    }
                }
            }else{
                if(index*2<=len && myNum<array[index*2].num) {
                    nextIndex=index*2;
                    nextIndexValue=array[index*2].num;
                }
                if(index*2+1<=len && myNum<array[index*2+1].num) {
                    if(nextIndexValue<array[index*2+1].num) {
                        nextIndex=index*2+1;
                    }
                }
            }
            if(nextIndex!=0) {
                sawp(nextIndex,index);
                toDown(nextIndex);
            }
        }
    }
    public void toUp(int index) {
        if(index==1) {
            return;
        }else {
            if(isMin){
                if(array[index/2].num>array[index].num) {
                    sawp(index/2,index);
                    toUp(index/2);
                }
            }else{
                if(array[index/2].num<array[index].num) {
                    sawp(index/2,index);
                    toUp(index/2);
                }
            }
        }
    }
    public void sawp(int a,int b) {
        if(isMin){
            int tempIndex=array[a].minHeapIndex;
            array[a].minHeapIndex=array[b].minHeapIndex;
            array[b].minHeapIndex=tempIndex;
        }else{
            int tempIndex=array[a].maxHeapIndex;
            array[a].maxHeapIndex=array[b].maxHeapIndex;
            array[b].maxHeapIndex=tempIndex;
        }

        data temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    public void remove(int index){
        sawp(index,len);
        array[len]=null;
        len--;
        if(len<=1 || index>len){
            return;
        }
        if(isMin){
            if(index/2>0 && array[index/2].num>array[index].num) {
                toUp(index);
            }else{
                toDown(index);
            }
        }else{
            if(index/2>0 && array[index/2].num<array[index].num) {
                toUp(index);
            }else{
                toDown(index);
            }
        }
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            myPQ maxq=new myPQ(false);
            myPQ minq=new myPQ(true);

            int k=Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st=new StringTokenizer(br.readLine());
                char operator=st.nextToken().charAt(0);
                int operand=Integer.parseInt(st.nextToken());
                if(operator=='I') {
                    data newData=new data(operand,0,0);
                    maxq.push(newData);
                    minq.push(newData);
                }else if(operator=='D') {
                    if(minq.isEmpty()) {
                        continue;
                    }
//                    System.out.println("\n========빼기전===========");
//                    System.out.println("\n최대힙");
//                    for (int i1 = 0; i1 < maxq.len; i1++) {
//                        data temp=maxq.array[i1+1];
//                        System.out.printf("%d %d %d |",temp.num,temp.maxHeapIndex,temp.minHeapIndex);
//                    }
//                    System.out.println("\n최소힙");
//                    for (int i1 = 0; i1 < minq.len; i1++) {
//                        data temp=minq.array[i1+1];
//                        System.out.printf("%d %d %d |",temp.num,temp.maxHeapIndex,temp.minHeapIndex);
//                    }
//                    System.out.println("\n===================");
                    if(operand==1) {
                        data temp=maxq.pop();
//                        System.out.printf("최대값 pop %d %d %d |",temp.num,temp.maxHeapIndex,temp.minHeapIndex);
                        minq.remove(temp.minHeapIndex);
                    }else {
                        data temp=minq.pop();
//                        System.out.printf("최소값 pop %d %d %d |",temp.num,temp.maxHeapIndex,temp.minHeapIndex);
                        maxq.remove(temp.maxHeapIndex);
                    }
//                    System.out.println("\n========뺀 후===========");
//                    System.out.println("\n최대힙");
//                    for (int i1 = 0; i1 < maxq.len; i1++) {
//                        data temp=maxq.array[i1+1];
//                        System.out.printf("%d %d %d |",temp.num,temp.maxHeapIndex,temp.minHeapIndex);
//                    }
//                    System.out.println("\n최소힙");
//                    for (int i1 = 0; i1 < minq.len; i1++) {
//                        data temp=minq.array[i1+1];
//                        System.out.printf("%d %d %d |",temp.num,temp.maxHeapIndex,temp.minHeapIndex);
//                    }
//                    System.out.println("\n===================");
                }
            }

//            System.out.println("\n===============================");
//            while(!maxq.isEmpty()){
//                data tempMax=maxq.pop();
//                System.out.printf("%d %d %d ",tempMax.num,tempMax.maxHeapIndex,tempMax.minHeapIndex);
//            }
//            System.out.println();
//            while(!minq.isEmpty()){
//                data tempMin=minq.pop();
//                System.out.printf("%d %d %d ",tempMin.num,tempMin.maxHeapIndex,tempMin.minHeapIndex);
//            }
            if(maxq.isEmpty()) {
                System.out.println("EMPTY");
            }else {
                System.out.printf("%d %d\n",maxq.array[1].num,minq.array[1].num);
            }
        }
    }
}