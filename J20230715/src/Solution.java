import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        //逆波兰表达式求值
        //先定义一个栈，把数存进去。
        //如果是符号，那就从栈中提取两个
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            //先从字符串中挨个提取出来
            //如果是+-*/运算符，那么就从栈中提取出两个数字来进行运算.
            if(isOperator(s)){
                //这里先弹出的命名为num2是因为,逆波兰表达式在使用时候，是第二个和第一个进行运算。就是先弹出的在右。
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(s){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num1/num2);
                        break;
                }
            }
            //如果不是运算符，那么就是数字，就把数字放到栈中.
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    //写一个方法判断是不是符号的表达式
    public boolean isOperator(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        return false;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //首先判断如果第一个是右括号，直接错误
        boolean sign = false;
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        //第一个是左括号的情况，就要进行递归检查
        else {
            while (stack.isEmpty()!=true) {
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    //如果是左括号，那么就放到栈中。
                    if (isLeftBracket(ch)) {
                        stack.push(ch);
                    }
                    //如果不是左括号，那么就检查右括号是否匹配.
                    else {
                        if (stack.pop() == ch) {
                            sign = true;
                        } else {
                            sign = false;
                        }
                    }
                }
            }
        }
        return sign;
    }
    //写一个判断是不是左括号的方法
    private boolean isLeftBracket(char c) {
        if(c == '(' || c == '{' || c == '['){
            return true;
        }
        return false;
    }
}