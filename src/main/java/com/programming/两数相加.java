package com.programming;

import com.alibaba.fastjson.JSON;

public class 两数相加 {
//    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//    请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//    示例 1：
//    输入：l1 = [2,4,3], l2 = [5,6,4]
//    输出：[7,0,8]
//    解释：342 + 465 = 807.
//    示例 2：
//
//    输入：l1 = [0], l2 = [0]
//    输出：[0]
//    示例 3：
//
//    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//    输出：[8,9,9,9,0,0,0,1]

//    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(2);
        l2.next.next = new ListNode(5);
        ListNode res = addTwoNumbers( l1,  l2);
        System.out.println(JSON.toJSON(res).toString());
    }

    public static ListNode addTwoNumbersErr(ListNode l1, ListNode l2){
        ListNode resNode  ;
        boolean flag = false;
        int tempSum = l1.val+ l2.val;
        if(tempSum>9){
            resNode = new ListNode(tempSum-10);
            flag = true;
        }else {
            resNode = new ListNode(tempSum);
        }
        ListNode temp = null;
        resNode.next = temp;
        while (l1.next != null || l2.next != null || flag){

            int l1v = 0;
            if(l1.next != null){
                l1v=l1.next.val;
            }
            int l2v = 0;
            if(l1.next != null){
                l2v=l1.next.val;
            }
            int singleSum = l1v+l2v;
            if(flag){
                singleSum +=1;
            }
            if(singleSum>9){
                temp = new ListNode(singleSum-10);
                temp = temp.next;
                flag = true;
            }else {
                temp = new ListNode(singleSum);
                temp = temp.next;
                flag = false;
            }
        }
        return resNode;
    }




//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        StringBuilder sba = new StringBuilder();
//        sba.append(l1.val);
//        ListNode l1Next = l1.next;
//        while (l1Next != null){
//            sba.append(l1Next.val);
//            l1Next = l1Next.next;
//        }
//        StringBuilder sbb = new StringBuilder();
//        sbb.append(l1.val);
//        ListNode l2Next = l2.next;
//        while (l2Next != null){
//            sbb.append(l2Next.val);
//            l2Next = l2Next.next;
//        }
//        String l1Reverse = sba.reverse().toString();
//        String l2Reverse = sbb.reverse().toString();
//
//    }
}
