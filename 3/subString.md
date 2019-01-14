# 2018/1/18

LeetCode第三题
---
前面的知识点：

equals是判断字符串的是不是相等，例如："abc".equals("abc"),返回结果是Boolean类型的true
"abc".equals("ab")返回结果是Boolean类型的false
contains是包含的意思，例如:"abc".contains("a"),返回结果是Boolean类型的true
"abc".contains("d"),返回结果是Boolean类型的false.
contains包含包括，"abc".contains("abcd")是返回的false

题目是：
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

就是给出一个字符串，找出最长的子字符串，并输出其长度

[代码](myLeetcode/3/Solution.java)
