package sort;

import java.util.concurrent.ConcurrentHashMap;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr= {5,9,3,7,2,3,10,15,4};
        int[] dup=new int[arr.length];
        HeapSort.sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }

    public static void sort(int[] arr){

        int start = arr.length/2;
        while(start>0){
            // sink
            sink(arr,start,arr.length);
            start-- ;
        }

        // swap
        for(int t= arr.length;t>0;t--){
            swap(arr,t,1);
            sink(arr,1,t);
        }


    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = temp;
    }

    public static void sink(int[] arr,int pos,int barrier){
        while(pos*2<barrier){
            int k= pos*2;
            if(k+1<barrier&&compare(arr, k, k+1)<0){k++;}
            if(compare(arr, pos, k)<0){
                swap(arr,pos,k);
                pos =k;
            }else{
                break;
            }

        }
    }

    public static int compare(int[] arr,int i,int j){
        return arr[i-1]-arr[j-1];
    }

}
