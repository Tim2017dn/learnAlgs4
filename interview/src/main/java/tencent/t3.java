package tencent;

import java.util.HashMap;
import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);

        String[] lines = new String[n];
        for(int i=0;i<n;i++){
            lines[i] = sc.nextLine();
        }

        handle(lines,m);

    }

    public static void handle(String[]lines,int m){
        findmax(lines,m);
    }

    public static void findmax(String[]lines,int m){
//
//        HashMap<> res = new HashMap()
//        for(int )
    }



}
