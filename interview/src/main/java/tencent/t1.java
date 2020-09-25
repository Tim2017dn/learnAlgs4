package tencent;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class t1 {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc =new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0;i<arr2.length;i++){
            arr2[i]=sc.nextInt();
        }

        String res = handle(arr1, arr2);
        System.out.println(res);

    }

    public static ListNode toListNode(int[] arr1){
        ListNode fir = new ListNode(arr1[0]);
        ListNode cur = fir;
        for(int i=1;i<arr1.length;i++){
            ListNode tmp = new ListNode(arr1[i]);
            cur.next = tmp;
            cur = cur.next;
        }
        return fir;
    }


    public static String handle(int[] arr1,int[] arr2) throws InterruptedException {
        if(arr1.length==0||arr2.length==0){
            return "";
        }
//        ListNode fir = new ListNode(arr1[0]);
//        ListNode cur = fir;
//        for(int i=1;i<arr1.length;i++){
//            ListNode tmp = new ListNode(arr1[i]);
//            cur.next = tmp;
//            cur = cur.next;
//        }
//
//        ListNode sec = new ListNode(arr2[0]);
//         cur = sec;
//        for(int i=1;i<arr2.length;i++){
//            ListNode tmp = new ListNode(arr2[i]);
//            cur.next = tmp;
//            cur = cur.next;
//        }

        CountDownLatch latch = new CountDownLatch(2);

        AtomicReference<ListNode> fir=null ;

        AtomicReference<ListNode> sec=null ;
        new Thread(()->{
            fir.set(toListNode(arr1));
            latch.countDown();
        }).start();

        new Thread(()->{
            sec.set(toListNode(arr2));
            latch.countDown();
        }).start();

        latch.await();


        String res = find(fir.get(), sec.get());
        return res;

    }

    public static String find(ListNode fir,ListNode sec){

        ListNode p = fir;
        ListNode q = sec;

        String result ="";
     //  ArrayList<Integer> res = new ArrayList<>();
        while(p!=null&&q!=null){
            if(p.val>q.val){
                p=p.next;
            }else if(p.val<q.val){
                q = q.next;
            }else {
              //  res.add(p.val);
                result +=p.val+" ";
                p = p.next;
                q = q.next;
            }

        }
        if(result==""){
            return result;
        }else{
            return result.substring(0,result.length()-1);
        }


    }



    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

}
