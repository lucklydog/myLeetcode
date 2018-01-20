这是一个时间复杂度为O(n^3)的算法：
思路是:
取出其中的子字符串，判断所截取的子字符串是否有重复
代码如下：
###
calss solution {
  public int lengthOfLongSubstring(String s){
    int length = s.length();//得出字符串的长度
    int len = 0;//记录最长子字符串
    //依次截取字符串
    for(int i = 0 ; i < s.length;i++){
      for(int j = i+1;j<s.length+1;j++){
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
