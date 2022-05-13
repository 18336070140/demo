package com.programming;

public class 删除有序数组中的重复项 {

    static class Solution {
        public static int removeDuplicates(int[] nums) {

            int write = 1;
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if(temp != nums[i] ){
                    temp = nums[i];
                    if(write < i){
                        nums[write] = nums[i];
                    }
                    write ++;
                }
            }
            return write;
        }
        public static void main(String[] args) {
            removeDuplicates(new int[]{1,2});
        }
    }

}
