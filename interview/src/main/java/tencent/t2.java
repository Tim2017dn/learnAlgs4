package tencent;

import java.util.*;

public class t2 {

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] group = new ArrayList[m];
        ArrayList<Integer>[] cango = new ArrayList[n];

        init(group);
        init(cango);


        for(int i=0;i<m;i++){
            int t= sc.nextInt();
            group[i] = new ArrayList<>();
            for(int j=0;j<t;j++){
                int tmp = sc.nextInt();
                group[i].add(tmp);
                if(cango[tmp]==null){
                    cango[tmp] = new ArrayList<>();
                }
                cango[tmp].add(i);
            }
        }


        handle(group,cango);

    }

    public static void init(ArrayList[] list){
        for(int i=0;i<list.length;i++){
            list[i]= new ArrayList();
        }

    }

    public static void handle( ArrayList<Integer>[] group, ArrayList<Integer>[] cango){

        Queue<Integer> queue =new  LinkedList<>();

        Queue<Integer> nextqueue =new  LinkedList<>();

        HashSet<Integer> flag = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        ArrayList<Integer> fir = find(0, cango);
        for(int i=0;i<fir.size();i++){
            int gr = fir.get(i);
            if(!flag.contains(gr)){
                ArrayList<Integer> gg = group[gr];
                for(int t=0;t<gg.size();t++){

                    if(!res.contains(gg.get(t))){
                        queue.add(gg.get(t));
                        res.add(gg.get(t));
                    }


                }
            }
            flag.add(gr);
        }


        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            ArrayList<Integer> curg = find(cur, cango);
            for(int i=0;i<curg.size();i++){
                int gr = curg.get(i);

                if(!flag.contains(gr)){
                    ArrayList<Integer> gg = group[gr];
                    for(int t=0;t<gg.size();t++){
                        if(!res.contains(gg.get(t))){
                            nextqueue.add(gg.get(t));
                            res.add(gg.get(t));
                        }


                    }
                }
                flag.add(gr);
            }

            if(queue.isEmpty()&&!nextqueue.isEmpty()){
                queue = nextqueue;
                nextqueue =new  LinkedList<>();
            }

        }
        System.out.println(res.size());

//        ArrayList result = new ArrayList();
//        Iterator<Integer> it = res.iterator();
//        while(it.hasNext()){
//            result.add(it.next());
//        }
//
//        Collections.sort(result);
//        for(int i=0;i<res)

    }

    public static ArrayList find(int val, ArrayList<Integer>[] cango){
        return cango[val];
    }

}


