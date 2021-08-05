package com.programming;

import java.util.ArrayList;
import java.util.List;

public class 有序列表合并去重 {

    // 两个有序列表组合成一个有序列表返回, 其中存在重复数字，合并后的列表去重
// 如[1,2,2,5,9], [2,3,3,5,8,10]
// 合并后 [1,2,3,5,8,9,10]，不能使用Set或List自带的排序方法
    public List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> list =new ArrayList<>();
        int len  = Math.min(list1.size(), list2.size());
        int m =0;
        int n =0;
        for (int i=0;i<=len;){
            int temp ;
            if (list1.get(m)<list2.get(n)){
                temp =list1.get(m);
                m++;
            } else if (list1.get(m)>list2.get(n)){
                temp =list2.get(n);
                n++;
            } else {
                temp =list1.get(m);
                m++;
                n++;
            }
            if (i==0){
                list.add(temp);
                i++;
            }else if (list.get(list.size()-1)!=temp){
                list.add(temp);
                i++;
            }
        }

        if (len == list1.size()){
            for (int i=len;i<list2.size();i++){
                int temp = list2.get(i);
                if (i==0){
                    list.add(temp);
                }else if (list.get(list.size()-1)!=temp){
                    list.add(temp);
                }
            }
        } else {
            for (int i=len;i<list1.size();i++){
                int temp = list1.get(i);
                if (i==0){
                    list.add(temp);
                }else if (list.get(list.size()-1)!=temp){
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
