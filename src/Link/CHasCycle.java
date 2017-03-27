package Link;

/**
 *

 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?


 */
public class CHasCycle {


    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
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
                return true;
            }

            len++;
            first=first.next;
        }

        return false;
    }
}
