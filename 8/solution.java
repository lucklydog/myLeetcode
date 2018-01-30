实现1：
思路
开始判断字符串是否为空，返回0
接下来抛弃空字符，直到不为空
判断正负，设置标志
判断是否超出int类型的取值范围
从字符串中找出的字符乘10 加上下一个字符得出最终结果

class Solution {
    public int myAtoi(String str) {
        int base = 0;
        int i = 0;
        int sign = 1;//记录字符串是否为负数。1为正数，-1 为负数
        if(str.isEmpty()) return 0;
        while(str.charAt(i) != ' '){
            i++;
        }
        if(str.charAt(i)=='-' || str.charAt(i)=='+'){
           sign = str.charAt(i++) == '-' ? -1:1;//如果为-那么将sign赋值为-1
        }
        while(i<str.length() && str.charAt(i)>='0' || str.charAt(i)<='9'){
            if(base>Integer.MAX_VALUE /10 || (base == Integer.MAX_VALUE /10 && str.charAt(i) > '7'))//判断是否超出int的取值范围
            {
                return (sign==1)? Integer.MAX_VALUE : Integer.MIN_VALUE;//返回
            }
            base = 10 * base +(str.charAt(i++)-'0');//字符-'0' 表示弱转化为int类型
        }
        return base * sign;
    }
}


实现2：

思路
