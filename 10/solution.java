实现1：
思路
递归思想从头开始依次判断否包含
class Solution {
    public boolean isMatch(String text, String pattern) {
      if(pattern.isEmpty()) return text.isEmpty();
      boolean first_match = (!text.isEmpty())&& (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0)  == '.');//判断两个字符串的第一个字符会否相等
      if(pattern.length()>=2 && pattern.charAt(1) == '*'){
        return (isMatch(text,pattern.substring(2)) || (first_match&&isMatch(text.substring(1),pattern)));//如果遇到pattern的长度大于2并且第二个字符为*，
      //找到* 左右两边都与text相等时                            //
      }
      else
      {
        return (first_match && isMatch(text.substring(1),pattern.substring(1)));
      }
    }
  }


目前还是搞不清楚这个操作，以后再来，先跳过
