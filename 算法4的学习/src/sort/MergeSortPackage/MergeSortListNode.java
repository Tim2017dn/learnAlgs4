package sort.MergeSortPackage;

import java.util.List;

public class MergeSortListNode {


    public static ListNode converString2ListNode(String str){
        String[] sarr = str.split(",");
        ListNode head = new ListNode(0);
        ListNode cur =head;
        for(int i=0;i<sarr.length;i++){
            cur.next = new ListNode(Integer.parseInt(sarr[i]));
            cur = cur.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = converString2ListNode("3,4,1");
        MergeSortListNode n1 =new MergeSortListNode();
        ListNode res = n1.sortList(head);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }

    }


    public ListNode sortList(ListNode head) {

        // 1、
        // 2、merge

        // 对于链表，将链表分成差不多长的两个部分
        // 可以采取快慢指针

        if(head==null||head.next==null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode part2 = slow.next;
        slow.next = null;
        ListNode fir = sortList(head);
        ListNode sec = sortList(part2);


        ListNode result = merge(fir, sec);
        return result;

    }

    public static ListNode merge(ListNode fir,ListNode sec){
        ListNode res = new ListNode(0);
        ListNode result =res;
        while(fir!=null&&sec!=null){
            if(fir.val<sec.val){
                res.next = fir;
                fir = fir.next;
            }else{
                res.next = sec;
                sec = sec.next;
            }
            res = res.next;
        }

        while(fir!=null){
            res.next = fir;
            fir = fir.next;
            res = res.next;
        }


        while(sec!=null){
            res.next = sec;
            sec = sec.next;
            res = res.next;
        }

        return result.next;
    }




    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){this.val = x;}
    }

}
