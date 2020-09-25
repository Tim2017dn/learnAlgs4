package NetEase;

import java.util.ArrayList;
import java.util.Scanner;

public class t3 {

   static ArrayList<Integer>[] adj=null;


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        String[] arg = sc.nextLine().split(" ");
        int M= Integer.parseInt(arg[0]);
        int N =Integer.parseInt(arg[1]);
        String line;
        line=sc.nextLine();

        handle(line,M,N);
    }

    public static void handle(String line,Integer M,Integer N){
        adj = new ArrayList[M];
        String[] sarr = line.split(" ");
        for(int i=1;i<=sarr.length;i++){
            Integer source = Integer.parseInt(sarr[i - 1]);
            if(adj[source]==null){
                adj[source]=new ArrayList<>();
            }
            adj[source].add(i);
            if(adj[i]==null){
                adj[i]=new ArrayList<>();
            }
            adj[i].add(source);
        }

        int[] map=new int[M];
        map[0]=1;
        dfs(0,N,map,1);
        System.out.println(max);


    }

    static int max =1;
    public static void dfs(int position,int left,int[] map,int hasReach){

        if(left==0){
            if(hasReach>max){
                max=hasReach;
            }
            return;
        }

        ArrayList<Integer> nextGo = adj[position];
        for(int i=0;i<nextGo.size();i++){
            Integer nextpos = nextGo.get(i);
            boolean nextFlag=true;
            if(map[nextpos]==0){
                // no go ever
                nextFlag=false;
                map[nextpos]=1;
                hasReach++;

            }
            left--;
            dfs(nextpos,left,map,hasReach);
            left++;
            if(!nextFlag){
                map[nextpos]=0;
                hasReach--;
            }
        }

    }



}
