package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class t4 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);



        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        handle(arr);


    }

    public static void handle(int[] arr){

        int mid =(arr.length-1)/2;
        for(int i=0;i<arr.length;i++){
            int[] dup = copy(i,arr);
            System.out.println(dup[mid]);
        }

    }

    public static int[] copy(int i,int[] arr){
        int[] dup = new int[arr.length-1];
        int idx = 0;
        for(int t=0;t<arr.length;t++){
            if(t!=i){
                dup[idx++] = arr[t];
            }
        }

         Arrays.sort(dup);
        return dup;
    }

}
