package com.programming;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列的长度 {

    //求最长连续序列的长度，
//例如，给出 [100, 4, 200, 1, 3, 2]，
//这个最长的连续序列是 [1, 2, 3, 4]。返回所求长度：4 。
//不能对array先进行排序，再求长度
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.remove(num)) {
                continue;
            }
            int count = 1;
            int tmp = num;
            while (set.remove(--num)) {
                count += 1;
            }
            while (set.remove(++tmp)) {
                count += 1;
            }
            res = Math.max(res, count);
            if (res >= set.size()) {
                break;
            }
        }
        return res;
    }
}
