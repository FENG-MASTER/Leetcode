package Link;

import java.util.List;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 链表排序,要求要常量的空间
 * 可用排序:
 *  快速
 *  堆
 *  归并
 *
 *  又因为题目就一个单向链表,目测归并会好很多,因为快排用到了随机定位,堆排也是,唯独归并没用到
 *
 *  当然,直接转数组做也行
 */
public class CsortList {

    public static ListNode sortList(ListNode head) {
        if (head==null){
            return null;
        }

        int [] arr=listToArr(head);
        quickSort(arr,0,arr.length-1);
        return arrToList(arr);

    }


    public static int[] listToArr(ListNode head){
        if (head==null){
            return new int[0];
        }


        int[] arr=new int[getLen(head)];

        int i=0;
        ListNode next=head;
        while (next!=null){

            arr[i]=next.val;
            i++;
            next=next.next;
        }

        return arr;


    }

    public static ListNode arrToList(int[] arr){
        if (arr==null||arr.length==0){
            return null;
        }

        ListNode head=new ListNode(arr[0]);
        ListNode next=head;
        for (int i=1;i<arr.length;i++){
            next.next=new ListNode(arr[i]);
            next=next.next;
        }

        return head;

    }


    public static int getLen(ListNode head){
        int len=0;
        ListNode next=head;
        while (next!=null){
            len++;
            next=next.next;
        }
        return len;
    }

    public static void quickSort(int[] arr,final int s,final int e){
        if (arr==null){
            return;
        }

        if (s>e){
            return;
        }

        int X=arr[s];

        int start=s;
        int end=e;

        while (start<end){

            while (arr[end]>X){
                end--;
            }



            if (start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;

                start++;
            }

            while (arr[start]<X){
                start++;
            }

            if (start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                end--;
            }

        }

        arr[start]=X;

        if (start==end){
            quickSort(arr,s,start-1);
            quickSort(arr,start+1,e);
        }


    }


    public static void main(String args[]){
        ListNode head=new ListNode(3);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(1);

        head.next=node1;
        node1.next=node2;
        node2.next=node3;

        ListNode newN=sortList(head);
        System.out.println("11");

    }




}
