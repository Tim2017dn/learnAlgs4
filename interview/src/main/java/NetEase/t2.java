package NetEase;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class t2 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String line = sc.nextLine();
        handle(line);

    }

    public static void handle(String line){

        Boolean[][] map = new Boolean[line.length()][line.length()];

        for(int i=0;i<map.length;i++){
            for(int j=i;j<map[0].length;j++){

                String tmp = line.substring(i, j + 1);
                boolean res = judge(tmp);
                map[i][j] = res;
            }
        }

        int max=0;
        for(int i=0;i<map.length;i++){

            for(int t=map[0].length-1;t>=i;t--){
                if(map[i][t]){
                    int len = t-i+1;
                    if(len>max){
                        max = len;
                    }
                    break;
                }
            }
        }
        System.out.println(max);


    }


    public static boolean judge(String line){

        HashMap<Character,Integer> hm =new HashMap();
        hm.put('a', 0);
        hm.put('b', 0);
        hm.put('c', 0);
        hm.put('x', 0);
        hm.put('y', 0);
        hm.put('z', 0);


        for(int i=0;i<line.length();i++){
            if(hm.containsKey(line.charAt(i))){
                int val = hm.get(line.charAt(i));
                hm.put(line.charAt(i),val+1);

            }
        }
        for(Character c:hm.keySet()){
            Integer num = hm.get(c);
            if(num%2==1){
                return false;
            }
        }
        return true;

    }


}
