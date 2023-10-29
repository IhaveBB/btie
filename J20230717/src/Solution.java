import java.util.*;
public class Solution {
    Stack<Integer> stack = new Stack<Integer>();
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pushV int整型一维数组 
     * @param popV int整型一维数组 
     * @return bool布尔型
     */
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        if(pushV.length == 0 || popV.length == 0)
        {
            return false;
        }
        //先存进来
        int j = 0;
        for(int i = 0;i < pushV.length;i++){
            stack.push(pushV[i]);
            while(!stack.empty() &&stack.peek() == popV[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
    
