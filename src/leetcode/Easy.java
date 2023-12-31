package leetcode;

import java.util.*;

/**
 * @author yhr
 * @date 2023/6/26-10:12
 */
public class Easy {

    public static void main(String[] args) {
        Easy function = new Easy();

        /**
         * 两数之和
         * */
        //int[] nums = new int[]{3,2,4};
        //System.out.println(Arrays.toString(function.twoSum(nums,6)));
        /**
         * 回文数
         * */
        //System.out.println(function.isPalindrome(120021))
        /**
         * 罗马数字转整数
         * */
        //System.out.println(function.romanToInt("IV"));
        /**
         * 删除有序数组中的重复项
         * */
        //int[] nums = {1,1,2,3,3,4,5,5};
        //System.out.println(function.removeDuplicates(nums));

        //int[] nums = {0,1,2,2,3,0,4,2};
        //function.removeElement(nums,2);
        //int[] nums = {1,3,5,6};
        //System.out.println(function.searchInsert1(nums,2));
        int[] nums = {9,9,9,9};
        System.out.println(function.plusOne(nums));
    }

    /**
     * 两数之和
     * 时间复杂度为O(n^2)
     */
    public int[] twoSum(int[] nums, int target) {
        int i;
        List<Integer> checkNum = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            for (int j = i+1; j < nums.length; j++) {
                if (i+1 < nums.length){
                    if (nums[i]+nums[j] == target){
                        checkNum.add(i);
                        checkNum.add(j);
                        return new int[]{i,j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * 两数之和
     * 时间复杂度为O(n)
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * 回文数
     * 时间复杂度O(log N)
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }


    /**
     * 罗马数字转整数
     * 时间复杂度O(n)
     * */
    public int romanToInt(String s) {
        int count = 0;
        int num = getNum(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int iNum = getNum(s.charAt(i));
            if (num < iNum){
                count = count-num;
            }else {
                count = count+num;
            }
            num = iNum;
        }
        count += num;
        return count;
    }
    private int getNum(char s){
        switch (s){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }

    /**
     * 删除有序数组中的重复项
     * 时间复杂度O(n)
     * */
    public int removeDuplicates(int[] nums) {
        int a= 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[a] != nums[i]){
                a++;
                nums[a] = nums[i];
            }
        }
        return a+1;
    }

    /**
     * 移除元素
     * 时间复杂度O(n)
     * */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length;j++) {
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 搜索插入位置
     * O(n)
     * */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
    /**
     * 搜索插入位置
     * O(log n)
     * */
    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int min = (left+right)/2;
            if (nums[min] == target){
                return min;
            }if (nums[min] < target){
                left = min+1;
            }else {
                right = min-1;
            }
        }
        return left;
    }

    /**
     * 加一
     * */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            if (digits[i] == 9) {
                digits[i]=0;
            }else {
                digits[i]++;
                return digits;
            }

        }
        int[] newDig = new int[digits.length+1];
        newDig[0] = 1;
        return newDig;
    }
}
