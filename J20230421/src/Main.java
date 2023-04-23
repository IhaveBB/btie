import javax.management.openmbean.CompositeType;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        int []arr={1,1,5,2,2,2,5};
        //singleNumber1(arr);
        //System.out.println(singleNumber2(arr));
        //transform(arr);
        //System.out.println(Arrays.toString(arr));
        //myBubbleSort(arr);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(average(arr));
        //reorder(arr);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(majorityElement(arr));
        System.out.println(threeConsecutiveOdds(arr));
    }
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for(int a = 1; a < nums.length; a ++){
            if(count > 0){
                if(num == nums[a]) {
                    count ++;
                }
                else {
                    count --;
                }
            }
            else {
                num = nums[a];
                count = 1;
            }
        }
        return num;
    }
    //给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
    //    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static void singleNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count == 1) {
                System.out.println(nums[i]);
                return;
            }
        }
    }



    //给定一个整型数组, 实现冒泡排序(升序排序)
    public static void myBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
    //如数组：[1,2,3,4,5,6]
    //调整后可能是：[1, 5, 3, 4, 2, 6]
    //public 调整顺序
    public static void reorder(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 1) {
                left++;
            }
            while (left < right && arr[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    public static double average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}