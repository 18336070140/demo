package com.programming;

import java.util.Arrays;

public class 归并 {
    /**
     * function sort(arr, startIndex = 0, endIndex = arr.length - 1) {
     *     // 递归结束条件：startIndex大于等于endIndex的时候
     *     if (startIndex >= endIndex) {
     *         return;
     *     }
     *
     *     // 折半递归
     *     let midIndex = parseInt((startIndex + endIndex) / 2);
     *     sort(arr, startIndex, midIndex);
     *     sort(arr, midIndex + 1, endIndex);
     *     // 将两个有序的小数组，合并成一个大数组
     *     merge(arr, startIndex, midIndex, endIndex);
     * }
     *
     * function merge(arr, startIndex, midIndex, endIndex) {
     *     // 新建一个大数组
     *     let tempArr = [];
     *     let p1 = startIndex;
     *     let p2 = midIndex + 1;
     *     let p = 0;
     *
     *     // 比较两个有序小数组的元素，依次放入大数组中
     *     while (p1 <= midIndex && p2 <= endIndex) {
     *         if (arr[p1] <= arr[p2]) {
     *             tempArr[p++] = arr[p1++];
     *         } else {
     *             tempArr[p++] = arr[p2++];
     *         }
     *     }
     *
     *     // 右侧小数组已排序完毕，左侧小数组还有剩余，将左侧小数组元素依次放入大数组尾部
     *     while (p1 <= midIndex) {
     *         tempArr[p++] = arr[p1++];
     *     }
     *     // 左侧小数组已排序完毕，右侧小数组还有剩余，将右侧小数组元素依次放入大数组尾部
     *     while (p2 <= endIndex) {
     *         tempArr[p++] = arr[p2++];
     *     }
     *
     *     for (let i = 0; i < tempArr.length; i++) {
     *         arr[i + startIndex] = tempArr[i];
     *     }
     * }

     */

    public static void main(String[] args) {

        int[] nums = { 2, 7, 8, 3, 1,4,5};
        System.out.println(Arrays.toString(nums));
//        sort(nums, 0, nums.length-1);
        splitArray(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，
     *     每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     * @param nums 待排序数组
     * @return 输出有序数组
     */
    public static int[] sort(int[] nums, int low, int high){
        int mid = (low+high)/2;
        if(low<high){
            // 处理左边
            sort(nums, low, mid);
            // 处理右边
            sort(nums, mid+1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }
    private static void merge(int[] nums, int low, int mid, int high) {
        // 定义一个辅助数组，所以该算法的空间复杂度为O（n）
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        // 找出较小值元素放入temp数组中
        while(i<=mid && j<=high){
            if(nums[i]<=nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        // 处理较长部分
        while(i<=mid){
            temp[k++] = nums[i++];
        }
        while(j<=high){
            temp[k++] = nums[j++];
        }
        // 使用temp中的元素覆盖nums中元素
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2+low] = temp[k2];
        }
    }


    private static void splitArray(int[] nums,int start,int end){

        int mid = (start+end)/2;
        if(start<end){
            splitArray(nums,start,mid);
            splitArray(nums,mid+1,end);
            sortMerge(nums,start,mid,end);
        }
        return;
    }

    private static void sortMerge(int[] nums,int start,int mid,int end){

        int[] temp = new int[end-start+1];
        int b = start;
        int j = mid+1;
        int k = 0;
        while (b<=mid && j<=end){
            if(nums[b]<=nums[j]){
                temp[k] = nums[b];
                k++;
                b++;
            }else {
                temp[k] = nums[j];
                k++;
                j++;
            }
        }
        while (b<=mid){
            temp[k] = nums[b];
            k++;
            b++;
        }
        while (j<=end){
            temp[k] = nums[j];
            k++;
            j++;
        }
        for (int i = 0; i < temp.length; i++) {
            nums[start+i] = temp[i];
        }
    }
}
