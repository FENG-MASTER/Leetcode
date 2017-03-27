package Link;

import java.util.List;

/**
 * Sort a linked list using insertion sort.
 *
 * 链表的插入排序,最好有个头节点,题目似乎是没有的,自己先给一个,到时候去掉
 * 日哦,这个我也可以写那么久,自己是多菜啊
 *
 * 主要要注意的是:插入法在链表用的话,不只是要考虑插入,你还要考虑删除啊,因为你要插入的元素已经从列表删除了啊,
 * 也要做相应处理
 *
 */
public class CListInsertion {

    public static ListNode insertionSortList(ListNode head) {
        if (head==null){
           return null;
        }

        if (head.next==null){
            return head;
        }

        ListNode sortHead=new ListNode(Integer.MIN_VALUE);//已经排序的节点指针,做了个头结点
        sortHead.next=head;
        ListNode unSortHead=sortHead.next;//还没有排序的节点指针
        ListNode sortTail;//已经排序的节点末尾

        while (unSortHead!=null){
            ListNode searchNode=sortHead;
            ListNode unSort=unSortHead;

            unSortHead=unSortHead.next;//指针指向下一个
            sortTail=sortHead;
            while (sortTail.next!=unSort){//获取到已经排序的节点末尾
                sortTail=sortTail.next;
            }

            while (unSort.val>searchNode.next.val){
                searchNode=searchNode.next;
            }

            if (searchNode.next!=unSort){//如果是自己,意味着在排序列里找不到,最后找到了自己,是不用移动的
                //如果不是自己
                ListNode temp=searchNode.next;
                ListNode tail=unSort.next;
                searchNode.next=unSort;
                unSort.next=temp;
                sortTail.next=tail;
            }



        }


        return sortHead.next;

    }


    public static void main(String args[]){
        ListNode head=new ListNode(3);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(1);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;

        ListNode newN=insertionSortList(head);

        System.out.println("");

    }


}
