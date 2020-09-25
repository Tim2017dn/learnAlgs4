package baidu;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class t1 {

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
       sort(arr);
        flag=true;
        res="-1";
        dfs(arr,0,arr.length);
        if(flag){
            int[] tmp=Arrays.copyOfRange(arr, 1,arr.length-1);
            dfs(arr,0,tmp.length);
        }

        System.out.println(res);
    }

    public static void sort(int[] arr){
        int start=0;
        int stop = arr.length-1;
        while(start<stop){
            while(arr[start]==5&&start<stop){
                start++;
            }
            while(arr[stop]==0&&start<stop){
                stop--;
            }
            if(start<stop){
                swap(arr, start, stop);
            }
        }
    }


    static boolean flag = true;
    //static int res =-1;
    static String res ="-1";

    public static void dfs(int[] arr,int t,int len){
        if(t==len){

            if(arr[0]==0||arr[len-1]==5){
                flag =false;
                return;
            }

            int sum=arr[0];
            for(int i=1;i<arr.length-1;i++){
                sum = sum*10+arr[i];
                sum= sum % 9;
            }


            if(sum==0){
                String tmp = "";
                for(int i=0;i<arr.length;i++){
                    tmp+=String.valueOf(arr[i]);
                }
                res = tmp;
                flag= false;
            }
            return;
        }else{
            for(int k=t;k<len;k++){
                swap(arr,k,t);
                dfs(arr,k+1,len);
                swap(arr,k,t);
                if(!flag){
                    return;
                }
            }

        }

    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
