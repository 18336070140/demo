package com.programming;

import com.alibaba.fastjson.JSON;

public class 链表反转 {

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
         ListNode(int x,ListNode next) {
             this.val = x; this.next = next;
         }
      }

    static class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode pre = null, cur = head, next = null;
            while(cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
        public static void main(String[] args) {
            ListNode node = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
            ListNode d = reverseList(node);
            System.out.println(JSON.toJSON(d).toString());
        }
    }
}
