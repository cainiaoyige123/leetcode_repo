package others.leetcodeWeek;
/* gh
 * 2020/8/12
 * 下午10:31
 */

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RobotGame {
    public static void main(String[] args) {

    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Pos> set=new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            Pos pos=new Pos(obstacles[i][0],obstacles[i][1]);
            set.add(pos);
        }

        int tempX=0;
        int tempY=0;
        int direction=1;
        for (int i = 0; i < commands.length; i++) {
            int command=commands[i];
            if(command==-1){//右转
                direction=(direction+3)%4;
            }else if(command==-2){//左转
                direction=(direction+1)%4;
            }else {//前进
                Pos pos1;
                switch (direction){
                    case 0:
                        for (int j = 1; j <= command; j++) {
                            tempX++;
                            pos1=new Pos(tempX,tempY);
                            if(set.contains(pos1)){
                                tempX--;
                                break;
                            }
                        }
                        break;
                    case 1:
                        for (int j = 1; j <= command; j++) {
                            tempY++;
                            pos1=new Pos(tempX,tempY);
                            if(set.contains(pos1)){
                                tempY--;
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (int j = 1; j <= command; j++) {
                            tempX--;
                            pos1=new Pos(tempX,tempY);
                            if(set.contains(pos1)){
                                tempX++;
                                break;
                            }
                        }
                        break;
                    case 3:
                        for (int j = 1; j <= command; j++) {
                            tempY--;
                            pos1=new Pos(tempX,tempY);
                            if(set.contains(pos1)){
                                tempY++;
                                break;
                            }
                        }
                }
            }
        }
        return tempX*tempX+tempY*tempY;
    }
    static class Pos{
        int x;
        int y;
        public Pos(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
