package Link;

/**
 *  Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.

 Follow up:
 Can you solve it without using extra space?


 */
public class CDetectCycle {

    public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode first=head;
        ListNode search=head;//用于搜索是否有重复
        int len=0;
        while (first!=null){
            //遍历
            search=head;//从头搜索
            int searchIndex=0;
            while (search!=first){
                search=search.next;
                searchIndex++;
            }

            if (searchIndex!=len){
                return search;
            }

            len++;
            first=first.next;
        }

        return null;

    }



    public static void main(String args[]){
        ListNode head=new ListNode(3);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(1);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=head;
        ListNode newN=detectCycle(head);

        System.out.println("");

    }

}
