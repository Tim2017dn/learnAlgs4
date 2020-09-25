//import java.util.*;
//
//public class t2 {
//
//    public static void main(String[] args) {
//        Scanner sc = new  Scanner(System.in);
//        int level = Integer.parseInt(sc.nextLine());
//        String[] arr= new String[level];
//        for(int i=0;i<level;i++){
//            arr[i]=sc.nextLine();
//        }
//
//        handle(level,arr);
//    }
//
//
//    public static void handle(int level,String[] arr){
//        int[][] matrix = new int[level][2*level+1];
//
//        for(int i=0;i<arr.length;i++){
//            String[] ceng = arr[i].trim().split(" ");split
//            for(int j=0;j<ceng.length;j++){
//                matrix[i][j]=Integer.parseInt(ceng[j]);
//            }
//
//        }
//
//        Set<Integer> zui = new HashSet<>();
//
//
//        for(int i=0;i<matrix[level-1].length-3;i++){
//            List list = maxIndex(i, matrix[level - 1]);
//            zui.addAll(list);
//
//        }
//
//        List<Integer> line = new ArrayList<>(zui);
//        for(int i=0;i<zui.size();i++){
//            dfs(line.get(i),level,matrix,matrix[level-1][line.get(i)]);
//        }
//
//        System.out.println(quanju);
//    }
//
//   static int quanju= 0;
//
//    public static int dfs(int index,int level,int[][]matrix,int add,List<Integer> res){
//
//        level--;
//        if(level == 0){
//            if(add>quanju){
//                quanju = add;
//               return 0;
//            }
//
//        }
//
//
//        List nextStep= new ArrayList();
//        for(;index>=0;index--){
//            nextStep.add(index);
//        }
//
//        int[] ceng= matrix[level-1];
//        List<Integer> maxCango = maxIndex(nextStep,ceng);
//        int cal = ceng[(int) maxCango.get(0)];
//        for(int i=0;i<maxCango.size();i++){
//             dfs(maxCango.get(i),level,matrix,cal+add);
//        }
//
//    }
//
//    public static List<Integer> maxIndex(List<Integer> ll, int[] arr) {
//        List res= new ArrayList();
//
//        int max = arr[ll.get(0)];
//        for(int i=0;i<ll.size();i++){
//            if(i==0){
//                max = arr[ll.get(0)];
//                res.add(ll.get(0));
//            }else{
//                if(arr[ll.get(i)]>max){
//                    res.clear();
//                    max = arr[ll.get(i)];
//                    res.add(ll.get(i));
//                }else if(arr[ll.get(i)]==max){
//                    res.add(ll.get(i));
//                }
//            }
//
//
//        }
//        return res;
//
//    }
//
//    public static List maxIndex(int i, int[] arr){
//        List res = new ArrayList();
//        res.add(i);
//        int max= arr[i];
//        if(max<arr[i+1]){
//            res.clear();
//            res.add(i+1);
//        }else if(arr[i+1]== max) {
//            res.add(i+1);
//        }
//
//
//        if(max<arr[i+2]){
//            res.clear();
//            res.add(i+2);
//        }else if(arr[i+2]== max) {
//            res.add(i+2);
//        }
//
//        return res;
//
//    }
//
//}
