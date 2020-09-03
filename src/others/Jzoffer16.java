package others;
/* gh
 * 2020/8/2
 * 下午11:24
 */

public class Jzoffer16 {
    public static void main(String[] args) {
        System.out.println(new Jzoffer16().myPow(2,9));
    }
    public double myPow(double x,int y){
        if(y==1){
            return x;
        }
        if(y%2==1){
            return x*myPow(x,(y-1)/2)*myPow(x,(y-1)/2);
        }else {
            return myPow(x,y/2)*myPow(x,y/2);
        }
    }
}
