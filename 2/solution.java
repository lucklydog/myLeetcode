我自己的想法是先将链表的数字取出来，然后相加，再存到另一个链表，输出
可是，这个只是适合小数字，当数字到达199999999999时，便无法实现
难受啊，兄弟


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int numOne=0,numTwo=0;//定义两个数用来存储两个链表所表示的数
        int i = 0,j = 0;
        while(l1 != null){
            numOne += l1.val*Math.pow(10,i++);
            l1 = l1.next;
        }
        while(l2 != null){
            numTwo += l2.val*Math.pow(10,j++);
            l2 = l2.next;
        }
        int sum = numOne + numTwo;//两数相加
        String sumS = String.valueOf(sum);//将sum转化为字符串类型，从后开始getChar()
        char [] chars = sumS.toCharArray();
        ListNode head = new ListNode(0);
        ListNode p = head;
        int length = chars.length-1;//防止数组下标越界
        //System.out.println(length);
        while(chars[length] != '\0' && length>=0){
        	 p.val = Integer.parseInt(String.valueOf(chars[length]));//将字符转化为int类型
        	// System.out.println(p.val);

        	 if(length==0)
        		 break;
        	 else {
        		 length -= 1;
             p.next = new ListNode(0);
        	 p = p.next;
        }
        }
        return head;
    }
}
=====
官方解答：学习
 - 将当前节点初始化为返回列表的虚拟头部
 - 初始化L1 和L2两个链表分别置为p,q，以及结果链表curr
 - 设置一个变量保存进位（即大于10）
 - 将两个链表的数取出相加
 - 记录进位
 - 所有链表下移
 - 判断是否有进位
 - 返回虚拟头部的next（不然会出现多余的0）
-----
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
