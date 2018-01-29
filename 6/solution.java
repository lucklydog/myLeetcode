实现1：

已经知道covert是以"Z"排序
利用数组的特点，一行一行加上所有的字符，再输出

class Solution {
    public String convert(String s, int numRows) {
        StringBuffer []  sb = new StringBuffer [numRows];//定义一个的字符串类型表示有多少行
        int len = s.length();//字符串的长度
        for(int m = 0 ;m < numRows ; m++){
            sb[m] = new StringBuffer();//保存每一行的字符
        }
        //以上初始化完成
        int k = 0;
        int i = 0;
        //
       while(k < len){//保证不超出字符串的长度
           for( i = 0;i<numRows && k< len ;k++ ){
               sb[i++].append(s.charAt(k));//一行一行往下加字符
           }
           i = i-2;//到达最后一行，返回上一行
           for(;i > 0 && k < len;k++){
               sb[i--].append(s.charAt(k));//往上加，直到第二行
           }
       }
        for(int l = 1;l<numRows;l++){//将所有的字符串数组加到一个数组中
            sb[0].append(sb[l]);
        }
        return sb[0].toString();//返回
    }
}
