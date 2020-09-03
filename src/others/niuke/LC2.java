package others.niuke;
/* gh
 * 2020/8/8
 * 下午1:19
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC2 {
    public static void main(String[] args) {
        String[] arr={"3","-4","+"};
        System.out.println(new LC2().evalRPN(arr));
    }
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (set.contains(s)) {
                int a=nums.pop();
                int b=nums.pop();
                switch (s) {
                    case "+":
                        nums.push(b + a);
                        break;
                    case "-":
                        nums.push(b - a);
                        break;
                    case "*":
                        nums.push(b * a);
                        break;
                    default:
                        nums.push(b / a);
                }
            } else {
                nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }
}
