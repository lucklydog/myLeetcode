实现1：

 思路
 将所给数字转化为String 类型
 将字符串逐个保存在数组中
 反向读出，在转化为int

 class Solution {
     public int reverse(int x) {
         String s = String.valueOf(x);
         //System.out.println(s);
         int len = s.length();
         char [] num = new char [len];
         int k = 0;
         for(int i = 0; i<len && k<len; i++){
             if(s.charAt(i)== '-'){
                 k = k+1;
                 num[len-1] = s.charAt(0);
             }
             num[i] = s.charAt(k++);
             //System.out.println(num[i]);
         }
         StringBuffer re = new StringBuffer();
         for(int j = len-1;j>=0;j--){
             re.append(num[j]);
             //System.out.println(num[j]);
         }
         //System.out.println(re);
         String reS = re.toString();
         //System.out.println(reS);
         int result = Integer.parseInt(reS);
         return result;
     }
 }

 事实证明，no way！！！！
 遇到大于int的范围的就黄了
 转化不过来
 pass
后来发现如果超出int范围 ，那么return 0


修改的代码
class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        //System.out.println(s);
        int len = s.length();
        char [] num = new char [len];
        int k = 0;
        for(int i = 0; i<len && k<len; i++){
            if(s.charAt(i)== '-'){
                k = k+1;
                num[len-1] = s.charAt(0);
            }
            num[i] = s.charAt(k++);
            //System.out.println(num[i]);
        }
        StringBuffer re = new StringBuffer();
        for(int j = len-1;j>=0;j--){
            re.append(num[j]);
            //System.out.println(num[j]);
        }
        //System.out.println(re);
        String reS = re.toString();
        //System.out.println(reS);
        int result = 0;
        try{
      result = Integer.parseInt(reS);
        }
        catch(Exception e){
            return 0;
        }
        return result;
    }
}
leetcode accepted！！！

 实现2：
 思路：取余

 代码如下
 class Solution {
   public int reverse(int x)
 {
    int result = 0;
    while(x != 0){
      int tail = x%10;//取余，得出最后一个数
      int resultNum = result*10 + tail;//结果集加入，最大的值为int的取值范围，超出就以最大值输出
      if ((resultNum - tail) / 10 != result)//判断是否超出int 的取值范围
         { return 0; }
       result = resultNum;
       x = x/10;//将x的值减少一位
    }
    return result;
  }
 }

实现3：
将字符串转化再判断是否为负数
与实现1相同，空间复杂度应该降低了，代码量也减少


 class Solution {
  public int reverse(int x)
  {
      int result = 0;
      String s = String.valueOf(x);
      String sb = new StringBuilder(s).reverse().toString();
      if(sb.charAt(sb.length()-1) == '-'){
          String newS = sb.substring(0,s.length()-1);
          try{
               result = -1* Integer.parseInt(newS);
          }catch(Exception e){
              return 0;
          }
      }
      else{
          try{
             result = Integer.parseInt(sb);
          }catch(Exception e){return 0;}
      }
     return result;
  }
}
