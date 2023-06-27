package leetcode;

import java.util.*;

/**
 * @author yhr
 * @date 2023/6/26-10:12
 */
public class Easy {

    public static void main(String[] args) {
        Easy function = new Easy();

//        int[] nums = new int[]{3,2,4};
//        System.out.println(Arrays.toString(function.twoSum(nums,6)));
        System.out.println(function.isPalindrome(120021));
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
            System.out.println(x % help/10);
            System.out.println(1/10);
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }

}
