package stack;

import java.util.Stack;

//入库  差 入栈。 最小值 更新最小
//出库 差  正  出 差+最小
//负 出最小  最小=最小-差
//最小栈单栈解法
public class MinStack {
    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(7);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.push(8);
        System.out.println(stack.getMin());
        stack.push(6);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
    }

}
class MyStack {
    private Stack<Integer> stack1=new Stack<>();
    int min=0;
    public int peek(){
        return stack1.peek();
    }

    public void push(int num){
        if(stack1.isEmpty()){
            stack1.push(num);
            min=num;
            return;
        }
        if(num<min){
            min=num;
        }
        stack1.push(num-min);
    }

    public int pop(){
        int num=stack1.pop();
        int x=min;
        if(num<0){
            min=min-num;
        }
        return x;
    }

    public int getMin(){
        return min;
    }
}