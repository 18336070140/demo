package com.programming;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 有效的括号 {

    class Solution {
        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();
            for(char c: s.toCharArray()){
                if(c=='(')stack.push(')');
                else if(c=='[')stack.push(']');
                else if(c=='{')stack.push('}');
                else if(stack.isEmpty()||c!=stack.pop())return false;
            }
            return stack.isEmpty();
        }

        public boolean isValid2(String s){
            Deque<Character> deque = new LinkedList();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if('(' == ch){
                    deque.push(')');
                }else if('[' == ch){
                    deque.push(']');
                }else if('{' == ch){
                    deque.push('}');
                }else if(deque.isEmpty() || ch != deque.pop()){
                    return false;
                }
            }
            return deque.isEmpty();
        }
    }
}
