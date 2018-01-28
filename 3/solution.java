这是一个时间复杂度为O(n^3)的算法：
思路是:
取出其中的子字符串，判断所截取的子字符串是否有重复
代码如下：
###
public class Solution {
    public int lengthOfLongestSubstring(String s) {

    int length = s.length();//得出字符串的长度
    int len = 0;//记录最长子字符串
    //依次截取字符串
    for(int i = 0 ; i < length;i++){
      for(int j = i+1;j<length+1;j++){
        if(ifCover(s,i,j))
          len = Math.max(len,j-i);//返回最长的子字符串
      }
    }
    return len;
  }
  public boolean ifCover(String s,int start ,int end){
    StringBuffer sb = new StringBuffer();//创建一个StringBuffer，方便添加
    for(int i = start;i<end;i++){
      String su = sb.toString();//将sb转化为string类型，方便后面的查找字符地方法
      char ch = s.charAt(i);
      if(su.indexOf(ch)!= -1)//依次查找每个字符是否在子字符串中
        return false;
      sb.append(ch);//没有变加入到新的字符串中
    }
    return true;
  }
}


但是呢这个算法，当字符串很长的时候，时间明显很大，因此LeetCode并不接受这种算发
#####
第二种算法，这种算法的时间复杂度为O(n)
思路是：
给出一个字符串例如：dacbaedc
利用一个HashSet存储未重复的子字符串
如果在HashSet中为出现的字符，就存储进去，并且将所给的字符串的下标往后移动一位
动作：
d为出现，add，j++ ->  a未出现，add，j++  -> c 未出现，add  -> b 未出现，add -> a 出现，那么找到上一次出现a的位置，i++
在这过程中设置一个变量，记录最长的子字符串。

代码：
class solution  {
  public int lengthOfLongSubstring(String s){
      int  n = s.length();//字符串的长度
      int len  = 0;//记录子字符串的长度
      Set <character> set = new HashSet();//定义哈斯列表
      int  i = 0,j = 0;//标记下标
      while(i<n && j<n){
        if(!set.contains(s.charAt(j))){
          set.add(s.charAt(j++));
          len = Math.max(len,j-i);//记录最长子字符串
        }
        else {
          set.remove(i++);//前标记往后移动 直到找到相同字符下标
        }
      }
      return len;//返回最长的子字符串的长度
  }
}
