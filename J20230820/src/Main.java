import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param S string字符串
     * @param T string字符串
     * @return bool布尔型
     */
    public boolean isSubsequence (String S, String T) {
        LinkedList<Character> list = new LinkedList<Character>();
        for(int i = 0; i < S.length(); i++) {
            list.offer(S.charAt(i));
        }
        for(int i = 0; i < T.length(); i++) {
            if(list.isEmpty()){
                return true;
            }
            char c = T.charAt(i);
            if(c == list.peek()){
                list.pop();
            }
        }

        return false;
    }
}