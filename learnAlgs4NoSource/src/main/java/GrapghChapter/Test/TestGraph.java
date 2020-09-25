package GrapghChapter.Test;

import GrapghChapter.Graph;

import java.io.File;
import java.io.IOException;

public class TestGraph {

    public static void main(String[] args) {

        test2();
    }

    public static void test1(){
        File directory = new File("");//设定为当前文件夹
        try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        }catch(Exception e){

        }
    }


    public static void test2(){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0,2);
        g.addEdge(2, 3);
        System.out.println(g.E());
        System.out.print("g: 点1 对应的边：");
        for(int v:g.adj(1)){
            System.out.print(v+",");
        }



        Graph g2  =new Graph(g);
        g.addEdge(1,2);
        System.out.println();
        System.out.print("g: 点1 对应的边：");
        for(int v:g.adj(1)){
            System.out.print(v+",");
        }

        System.out.println();
        System.out.print("g2: 点1 对应的边：");
        for(int v:g2.adj(1)){
            System.out.print(v+",");
        }

        System.out.println();
        System.out.println(g.hasEdge(1, 2));
        System.out.println(g.hasEdge(1, 3));

        g.addEdge(1, 2);
        System.out.print("g: 点1 对应的边：");
        for(int v:g.adj(1)){
            System.out.print(v+",");
        }
    }
}
