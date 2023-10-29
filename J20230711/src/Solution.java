import java.util.ArrayList;
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null||nums.length == 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i)==val){
                list.remove(Integer.valueOf(val));
            }
        }
        list.remove(Integer.valueOf(val));
        //修改后的数据放入原数组
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }
////////////////////////////////////////////////////////////////////////////////////////
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //使用arraylist解决此问题
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> list= new ArrayList<>();
        int i = 0;
        int j = 0;
        //
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        while (i < m) {
            list.add(nums1[i]);
            i++;
        }
        while (j < n) {
            list.add(nums2[j]);
            j++;
        }
        for (int k = 0; k < list.size(); k++) {
            nums1[k] = list.get(k);
        }
    }
}




