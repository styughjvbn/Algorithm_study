class Solution {
    int collision = 0;
    public int solution(int[][] points, int[][] routes) {
        int n = points.length;
        int x = routes.length;
        int[][] center = new int[101][101];

        Robot[] robots = new Robot[x];
        for(int i =0;i<x;i++){
            int[] route = routes[i];
            int[] point = points[route[0] -1];
            robots[i] = new Robot(point[0],point[1],route,points[route[1] - 1]);
            if(center[point[0]][point[1]] == 1){
                collision++;
            }
            center[point[0]][point[1]]++;
        }

        boolean existRemainRobot = true;
        while(existRemainRobot){
            center = new int[101][101];
            existRemainRobot = false;
            for(Robot robot: robots){
                if(robot.isGoal) continue;
                existRemainRobot = true;
                collision+=robot.move(center);
                if(robot.isArrivePoint()){
                    robot.changeTargetPoint(points);
                }
            }
        }

        return collision;
    }
}

class Robot{
    int r,c;
    int[] route;
    int curTargetPointIdx;
    int[] curTargetPoint;
    boolean isGoal = false;

    Robot(int r, int c, int[] route, int[] curTargetPoint){
        this.r =r;
        this.c =c;
        this.route =route;
        this.curTargetPoint = curTargetPoint;
        this.curTargetPointIdx = 1;
    }

    public int move(int[][] center){
        if(curTargetPoint[0] != r){
            r+=curTargetPoint[0]>r?1:-1;
        }else if(curTargetPoint[1] != c){
            c+=curTargetPoint[1]>c?1:-1;
        }
        int collision = 0;
        if(center[r][c] == 1){
            collision++;
        }
        center[r][c]++;
        return collision;
    }

    public boolean isArrivePoint(){
        return curTargetPoint[0] == r && curTargetPoint[1] == c;
    }

    public void changeTargetPoint(int[][] points){
        curTargetPointIdx++;
        if(curTargetPointIdx >= route.length){
            isGoal = true;
            return;
        }
        curTargetPoint = points[route[curTargetPointIdx] - 1];
    }
}