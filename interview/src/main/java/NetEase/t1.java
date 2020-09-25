package NetEase;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class t1 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
        String[] arg = sc.nextLine().split(" ");
        int M= Integer.parseInt(arg[0]);
        int N =Integer.parseInt(arg[1]);
        String[] lines = new String[N];
        
        for(int i=0;i<N;i++){
           
           lines[i]=sc.nextLine();
        }
       
        handle(lines);
        
        
        
    }
    
    public static void handle(String[] lines){

        TreeNode root = toTree(lines);
        res = 0;
        dfs(root);
        System.out.println(res);


    }

    static int res =0;
    public static void dfs(TreeNode cur){


        if(cur==null){
            return;
        }

        if(cur.left==null||cur.right==null){

            dfs(cur.left);
            dfs(cur.right);

        }else{
            if(isLeaf(cur.left)&&isLeaf(cur.right)){
                res++;
            }else{
                if(!isLeaf(cur.left)){
                    dfs(cur.left);
                }
                if(!isLeaf(cur.right)){
                    dfs(cur.right);
                }


            }
        }


    }

    public static boolean isLeaf(TreeNode cur){

        if(cur == null){return false;}

        return (cur.left==null)&&(cur.right==null)?true:false;
    }

    
    public static TreeNode toTree(String[] lines){
        
        HashMap<String, TreeNode> hm=new HashMap<>();
        for(int i=0;i<lines.length;i++){
            String[] tmp = lines[i].split(" ");
            
            TreeNode curNode=null;
            if(hm.containsKey(tmp[0])){
                 curNode = hm.get(tmp[0]);
            }else{
                 curNode = new TreeNode(Integer.parseInt(tmp[0]));
                 hm.put(tmp[0],curNode);
            }

            TreeNode nextNode=null;
            if(tmp[1].equals("left")){
                if(hm.containsKey(tmp[2])){
                    nextNode = hm.get(tmp[2]);
                }else{
                    nextNode = new TreeNode(Integer.parseInt(tmp[2]));
                    hm.put(tmp[2],nextNode);
                }
                curNode.left = nextNode;
                
            }else{
                if(hm.containsKey(tmp[2])){
                    nextNode = hm.get(tmp[2]);
                }else{
                    nextNode = new TreeNode(Integer.parseInt(tmp[2]));
                    hm.put(tmp[2],nextNode);
                }
                curNode.right = nextNode;
            }
            
            

        }
        return hm.get("1");
        
    }
    
    
    static class TreeNode{
        
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val){
            this.val = val;
        }
        
        public boolean isYin(){
            return (left==null)&&(right==null);
        }
        
    }
    

}
