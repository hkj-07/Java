/*
链表练习
包括链表的插入删除
 */
public class Node {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);	//创建链表对象 l1 （对应有参 和 无参 构造方法）
        ListNode head=null,tail=null;
        head=tail=new ListNode(8);
        tail.add(2);
        tail.add(3);
        head.add(4);
        head.print();
        System.out.println("\n");
        tail.print();
        System.out.println("\n");
        ListNode l4=l1;
        l1.add(2);				//插入结点，打印
        l1.add(3);
        l1.print();
        System.out.println("\n");
        l4.print();
        System.out.println("\n");
        ListNode l2=new ListNode(0);
//        l2.add(1);
//        l2.add(2);
        ListNode l3=l1.next;
//        l2.print();
//        l3.print();
    }
}
class ListNode{
    int val;	//数值 data
    ListNode next;	// 结点 node

    ListNode(int x){	//可以定义一个有参构造方法，也可以定义一个无参构造方法
        val = x;
    }
    // 添加新的结点
    public void add(int newval) {
        ListNode newNode = new ListNode(newval);
        if(this.next == null){
            this.next = newNode;}
        else{
            this.next.add(newval);}
    }
    // 打印链表
    public void print() {
        System.out.print(this.val);
        if(this.next != null)
        {
            System.out.print("-->");
            this.next.print();
        }
    }
}


