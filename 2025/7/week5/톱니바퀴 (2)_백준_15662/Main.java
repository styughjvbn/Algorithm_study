import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CogWheel{
    int base = 0;
    char[] poleStatus;

    CogWheel(char[] poleStatus){
        this.poleStatus = poleStatus;
    }

    void rotate(int direction){
        base = ((base + 8) + (direction*-1))%8;
    }

    char getLeftAdjustPole(){
        return poleStatus[(base + 6)%8];
    }

    char getRightAdjustPole(){
        return poleStatus[(base + 2)%8];
    }
}

class CogWheelRotator{
    int t;
    CogWheel[] cogWheels;

    CogWheelRotator(int t,CogWheel[] cogWheels){
        this.t = t;
        this.cogWheels = cogWheels;
    }

    public void rotate(int cogWheelNum, int direction){
        spreadLeft(cogWheelNum, direction);
        spreadRight(cogWheelNum, direction);
        cogWheels[cogWheelNum].rotate(direction);
    }

    public void spreadLeft(int cogWheelNum, int direction){
        if(cogWheelNum < 1) return;
        CogWheel affectedGear = cogWheels[cogWheelNum-1];
        CogWheel influencingGear = cogWheels[cogWheelNum];

        if( affectedGear.getRightAdjustPole() != influencingGear.getLeftAdjustPole()){
            spreadLeft(cogWheelNum - 1, direction * -1);
            affectedGear.rotate(direction * -1);
        }
    }
    public void spreadRight(int cogWheelNum, int direction){
        if(cogWheelNum >= t - 1) return;
        CogWheel affectedGear = cogWheels[cogWheelNum+1];
        CogWheel influencingGear = cogWheels[cogWheelNum];

        if( affectedGear.getLeftAdjustPole() != influencingGear.getRightAdjustPole()){
            spreadRight(cogWheelNum + 1, direction * -1);
            affectedGear.rotate(direction * -1);
        }
    }
}

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        CogWheel[] cogWheels = new CogWheel[t];

        for (int i = 0; i < t; i++) {
            cogWheels[i] = new CogWheel(br.readLine().toCharArray());
        }
        CogWheelRotator cogWheelRotator = new CogWheelRotator(t, cogWheels);
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cogWheelNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            cogWheelRotator.rotate(cogWheelNum, direction);
        }

        int result = 0;
        for (CogWheel cogWheel : cogWheels) {
            if (cogWheel.poleStatus[cogWheel.base] == '1') result++;
        }
        System.out.println(result);
    }
}