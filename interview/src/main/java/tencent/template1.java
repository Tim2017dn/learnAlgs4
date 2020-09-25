package tencent;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class template1 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int time = Integer.parseInt(sc.nextLine());

        while(time-->0){

            String[] sarr = sc.nextLine().split(" ");
            int[] arr = new int[sarr.length];
            for(int i=0;i<sarr.length;i++){
                arr[i]=Integer.parseInt(sarr[i]);
            }
            List<Integer> list = Arrays.asList(sarr).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            handle2(list);
        }

    }


    public static void handle(int[] arr){

    }

    public static void handle2(List list){
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
