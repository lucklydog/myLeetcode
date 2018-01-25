问题的解决是找出两个数组的的中间部分
考虑将一个数组分为左右两部分
        左             |      右
A[0] A[1] A[i-1]           A[i]  A[i+1]  A[m]
B[0] B[1] B[j-1]           B[j]  B[j+1]  B[n]

如果A[i-1]<= B[j] 并且 B[j-1]<=A[i]
就说明找到了正确的i使得A B 数组的连接部分（数据的大小相差不大）且左边的长度等于右边的长度

接下来就是找出左边部分的最大值以及右边的最小值，这两个值相加除于2就是中数
其中A数组的长度必须必B数组的长度
因为在定义B数组的下标j时 为了确保j和i 能使左右两边的长度相等
j = (m+n+1)/2 - i
因为i最大位m，所以当m>n时，j会出现负数，所以开始就得判断m是否小于n，如果不是要把A B 数组互换

根据二分查找，应该中A数组的中间找起因此设置变量iMin = 0，iMax = m，将i初始化为（iMin+iMax）/2
判断条件：1、 如果i<iMax && A[i] <= B[j-1] 证明i太小，将iMin加一
          2、 如果 i>iMin && B[j] <= A[i-1] 证明i太大，将iMax减一
找出左部分的最大值以及右部分的最小值

当遇到i等于0  （j等于0） 时
就是A[i-1]  (B[j-1])  不存在时 那么说明左边部分的最大值为B[j-1]  (A[i-1])
当i等于m（j等于n）
就是A[i](B[j]) 不存在时 那么说明 右边部分的最小值为 B[j]  （A[i]）

最后返回左右部分的平均值，即两个数组的中数

代码如下：
public double findMedianSortedArrays(int [] nums1,int [] nums2){
  int m = nums1.length,n = nums2.length;//得出两个数组的长度
  if(m>n){
    // 确保m< = n
    int [] temp = nums1 ;nums1 = nums2; nums2 = temp;
    int tmp = m;m = n; n = tmp;
  }
  int iMin = 0; int iMax = m;//设置i的范围
  int HalfLen = (m+n+1)/2;//确定连个数组的半长
  while(iMin<iMax){
    int  i = (iMin+iMax)/2;//利用二分法确定IDE值
    int j  = HalfLen - i ;//确定j的值，同时确保左右部分的长度相等
    if(i<iMax && nums1[i]< nums2[j-1]){//说明i太小
        iMin +=1;
    }
    else if (i>iMin && nums2[j] < nums1[i-1]){//说明i太大
      iMax -= 1;
    }
    //找到最佳i，找出左最大，右最小
    else {
      int maxLeft = 0;
      if(i == 0) {
        maxLeft = nums2[j-1];
      }
      else if(j == 0){
        maxLeft = nums1[i-1];
      }
      else {
        maxLeft = Math.max(nums1[i-1],nums2[j-1]);
      }
      if((m+n)%2 == 1)
        return maxLeft;//如果两个数组的长度和为奇数，返回左边最大值即可
      int minRight = 0;//找出右边最小值
      if(i == m){
        minRight = nums2[j];
      }
      if(j == n){
        minRight = nums1[i];
      }
      else{
        minRight = Math.min(nums1[i],nums2[j]);
        }
        return  (minRight+maxLeft)/2.0;//除于2.0表示返回double类型
    }
  }
   return 0.0;
}


另一种解法：
考虑将两个数组合并，求出中数
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    final int [] bothArrays = IntStream.concat(Arrays.stream(nums1), Arrays.stream
            (nums2)).sorted().toArray();
    double median;
    final int length = bothArrays.length;
    if (length % 2 == 0){
        median = (double) (bothArrays[length / 2] + bothArrays[length / 2 - 1]) / 2;
    } else {
        median = (double) bothArrays[length / 2];
    }
    return median;
}
这种解法也是接受，感觉有点容易
