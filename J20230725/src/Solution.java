class Solution {
    public int addDigits(int num) {
        int tmp = 0;
        while(num<=10){
            tmp = num % 10;
            num = tmp + num/10;
        }
        return num;
    }
}