class Solution {
    public static void main(String[] args) {
        //System.out.println(truncateSentence("Hello how are you Contestant", 4));
        //int [] nums =  {1,1,2,3,4,5,6,7,8,9,10};
        //System.out.println(removeDuplicates(nums));
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int []  temp = new int[nums.length];
        temp[0] = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length-1; i++){
           if(nums[i]!= nums[i+1]){
               temp[count] = nums[i];
               count++;
           }
        }
        for(int i = 0; i < count; i++){
            nums[i] = temp[i];
        }
        return count;
    }





    public static String truncateSentence(String s, int k) {
        //新建一个存储修改后字符串的字符串。
        StringBuilder sb = new StringBuilder();
        int sign = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sign++;
                if (sign == k) {
                    break;
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

