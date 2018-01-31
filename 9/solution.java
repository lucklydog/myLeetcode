class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int  i = 0;
        char ch = s.charAt(0);
        if(ch  == '-'){
         return  false;
        }
        String newS = new StringBuilder(s).reverse().toString();//将字符串颠倒
        if(newS.equals(s))//相等就返回true
            return true;
        return false;
    }
}




 实现2： 左右charAt，如果不同 返回false，时间稍微快了一点
class Solution{
  public boolean isPalindrome(int x){
    String s = String.valueOf(x);//将int转化为字符串类型
    if(s.length() == 0 || s.length() == 1) return true;//如果字符串的长度为0或者为1，x一定为回文的
    int start = 0 ;int end = s.length()-1;
    while(start<=end){
      if(s.charAt(start) != s.charAt(end))
        reurn false;
      start++;
      end--;
    }
    return true;
  }
}
