package Link;

import java.util.ArrayList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class CReorderList {
    //TODO:然而并没有符合题目要求的空间要求,题目的in-place的意思是没有额外空间,有个空间o(1)的做法,参照https://segmentfault.com/a/1190000003815785的逆序合并法,然而好难哦
    public static void reorderList(ListNode head) {
        if (head==null){
            return;
        }


        int len=0;
        ListNode node=head;

        while (node!=null){
            len++;
            node=node.next;
        }


        ListNode nodesOld[]=new ListNode[len];
        int iii=0;
        node=head;
        while (node!=null){
            nodesOld[iii]=node;
            iii++;
            node=node.next;
        }

        ListNode nodes[]=new ListNode[len];


        for (int i =0;i<len;i++){
            nodes[i]=nodesOld[hash(i,len-1)];
        }



        for (int ii =0;ii<len;ii++){
            if (ii+1<len){
                nodes[ii].next=nodes[ii+1];
            }else {
                nodes[ii].next=null;
            }
        }

    }






    public static int hash(int i,int n){
        if (n==0){
            return 0;
        }

        if (i%2==0){
            //偶数
            return i/2;
        }else {
            return n+i/2+1-i;
        }
    }





    public static void main(String args[]){
        ListNode head=new ListNode(0);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;


        reorderList(head);


        System.out.println("");
    }


}
