实现1；
先找出头尾是相同的字符
判断是否构成一个回文字符串

class Solution {
   public String longestPalindrome(String s){
  int len = 0;
  int n = s.length();
  int p =0 ;int q = 0;
  for(int i = 0;i<n;i++){
    for(int j = n-1 ;j>=i;j--){
      if(s.charAt(i)==(s.charAt(j))){
        String m = s.substring(i,j+1);
          //System.out.println(m);
        if(len<j-i && judgeIfPalin(m)){
          p = i;
          q= j;
          len = j-i;
        }
      }
    }
  }
  return s.substring(p,q+1).toString();
}
public boolean judgeIfPalin(String s){
  int l = s.length()-1;
  int i = 0;
  while(i < l){
    if(s.charAt(i++) != s.charAt(l--)){
      return false;
    }
  }
    return true;
}
}
这个算法时间复杂度为O(n^3)，leetcode不接受。。

实现2：中间向两边扩散方法

算法思路：
考虑两种情况
一：回文字符串的中间只是一个字符 eg：abcba   中间为c
二：回文字符串的中间有两个字符 eg： abccba  中间为cc
由中间除法向两边扩散查找，直到两边不等，记录最长的子字符串
返回结果

代码如下：
public String longestPalindrome(String s){
  int start = 0; //记录最长回文字符串的起点
  int end = 0; //记录最长回文子字符串的终点
  int len = 0 ;//记录长度
  int n = s.length();
  //遍历一遍字符串，找到中间的字符，i为回文字符串的中间点
  for(int i = 0 ; i< n ;i++){
    int len1 = judgeIfPalin(s,i,i);//考虑第一种情况
    int len2 = judgeIfPalin(s,i,i+1);//考虑第二种情况
     len = Math.max(len1,len2);//得出最长的
    if(len>end - start){
      start = i-(len-1)/2;//得出子字符串的起点
      end =  i+len/2;//得出终点
    }
  }
  return s.substring(start,end+1).toString();
}
public int judgeIfPalin(String s, int start, int end){
  int L = start, R = end;
  //由中间出发，判断左右字符是否相等，如果相等，那么判断下一个字符，直到不相等
  while (L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
    L--;
    R++;
  }
  return R-L-1;
}

 算法接受!

 实现3：动态规划法

 思路：
 实现动态规划，就是前面得出的结构会影响后面的计算
 一个字符串，比如 abcba 知中间三位为回文数组，那么就只需要判断左右两个数是否相等
利用一个数组，这个数组记录的是每一个子字符串的起点还有终点，true 为回文，false 不为回文
代码如下：

class Solution {

public String longestPalindrome(String s){
    int n = s.length();
  boolean  [][] P = new boolean [n][n];//记录起点为i 终点为j的子字符串是否为回文子字符串
  for(int k =0 ;k<P.length;k++){
    for(int l = 0; l<P[k].length;l++){
      P[k][l] = false;
    }
  }
  int maxLength = 0;//记录长度
  int start = 0;//记录回文字符串的起点

  for(int i = 0; i<n ; i++){//初始化回文数组
    P[i][i] = true;//单一个字符是一个回文字符串
    if(i<n-1 && s.charAt(i)== s.charAt(i+1) ){//如果前后两个字符相等，那么两个字符串也是回文
      P[i][i+1] = true;
      maxLength = 2;
      start = i;
    }
  }
  //以上将两个字符的全部判断完毕，记下来判断3记下来判断3个字符以上的
  for(int len = 3 ; len <=n ; len ++){
    for(int m = 0 ; m <= n-len ; m++){//m 记录子字符串的起点下标
      int end = m + len -1;//记录字符串的终点下标
      if(P[m+1][end-1] && (s.charAt(m) == s.charAt(end))){//如果字符串的前一部分为回文并且两端的字符相等，那么可以确定次字符串为回文，符合动态规划的算法
        P[m][end] = true;
        maxLength = len;
        start = m ;
      }
    }
  }
  if(maxLength >= 2){
    return s.substring(start,start+maxLength).toString();
  }
  return s.substring(0,1).toString();
}
}


leetcode 较快的算法

public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;

    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}
