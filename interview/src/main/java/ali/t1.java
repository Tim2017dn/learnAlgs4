package ali;

import java.util.ArrayList;
import java.util.Scanner;

public class t1 {


    public static void main(String[] args) {
        Scanner sc =new Scanner( System.in);
        int num = sc.nextInt();
        String res = handle(num);
        System.out.println(res);
    }

    public static String handle(int num){

        String[] arr ={"2","3","5"};
        if(num<=3){
            return arr[num-1];
        }
        num=num-3;

        ArrayList<String> queue=new ArrayList<>();
        queue.add("2");
        queue.add("3");
        queue.add("5");

        ArrayList<String> nextqueue=new ArrayList<>();
        int qu=0;
        while(!queue.isEmpty()&&num>0){

            String str = queue.get(qu);
            for(int j=0;j<3;j++){
                String res1 = str+arr[j]  ;
                nextqueue.add(res1);
                num--;
                if(num<=0){
                    break;
                }
            }
            if(num==0){
                break;
            }
            qu++;
            if(qu==queue.size()){
                queue = nextqueue;
                nextqueue=new ArrayList<>();
                qu=0;
            }


        }

        return nextqueue.get(nextqueue.size()-1);


    }

}
