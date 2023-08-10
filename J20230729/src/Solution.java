import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        //判断其中一个能不能变成另一个
        //只需要判断他们里的字符的数量是否相同
        //或者给他们排个序？，重写一下compare方法
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : stones){
            queue.add(i);
        }

        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            if(a > b){
                queue.add(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public int countCharacters(String[] words, String chars) {
        //先统计chars里，每个字母出现了多少次
        int c[] = new int[26];
        int cc[] = new int[26];
        int length = 0;
        for(char ch : chars.toCharArray()){
            int index = (int)(ch - 'a');
            c[index]++;
        }
        //因为words是一个字符串数组，words[0]等于一个字符串,所以外层的for循环，每一个word代表一个代词，然后循环判断每个单词
        for(String word : words){
            boolean flag = true;
            //内层的for循环，再对每个单词进行细致的判断
            for(char ch : word.toCharArray()){
                int index = (int)(ch - 'a');
                cc[index]++;

                if(cc[index]>c[index]){
                    flag = false;
                }
            }
            if(flag){
                length = length + word.length();
            }
        }
        return length;
    }


    public int dayOfYear(String date) {
        String [] arrDate = date.split("-");
        if (arrDate.length != 3) {
            return -1; // 输入日期格式不正确，返回特殊值表示错误
        }
        int length = 0;
        int year = Integer.parseInt(arrDate[0]);
        int month = Integer.parseInt(arrDate[1]);
        int day = Integer.parseInt(arrDate[2]);

        while(month > 1) {
           length += day;
           month--;
           length += determineDaysOfMonth(year, month);

        }
        return length;
    }

    private int determineDaysOfMonth(int year, int month) {
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return -1;
    }
}

