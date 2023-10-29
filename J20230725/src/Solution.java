/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int tmp ;
        int m = 1;
        int random = 0;
        while{
            //m-n之间的随机数
            random = (int)(Math.random()*(n-m)+m);
            //tmp接受，我猜的数是否正确
            tmp = guess(random);
            if(tmp == 0){
                return random;
            }
            else if(tmp == 1){
                //如果我选出的数字比你猜的数字大，那么让最小是等于我猜的数字
                m = random;
            }
            else if(tmp == -1){
                //我选出的数字比你猜的数字小,那么让最大值等于我猜的数字
                n = random;
            }
        }(tmp == 0);
        return random;
    }
}