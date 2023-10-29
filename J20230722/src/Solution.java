import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> seen = new ArrayList<>();
        int count = 0;
        while(n!=0) {
            int sum =0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
            count ++;
            if(n == 1) {
                return true;
            }
            else if(count == 20){
                return false;
            }
        }
        return false;
    }
}