package graphPackage;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFile {

    public static void main(String[] args) throws IOException {

//        File f=new File("E:\\ProjectWorkspace\\IDEAWorkspace\\算法4的学习\\src\\graphPackage\\tinyG.txt");

        InputStream is = new FileInputStream("E:\\ProjectWorkspace\\IDEAWorkspace\\算法4的学习\\src\\graphPackage\\tinyG.txt");

//        int size = f.available();

//        for (int i = 0; i < size; i++) {
//            System.out.print((char) f.read() + "  ");
//        }


//        int temp;
//        while((temp=is.read())!=-1){
//            System.out.print((char)temp+" ");
//        }
//
//        System.out.println((char)10+"1");
//        System.out.println("\n\r"+"1");
//
//        is.close();

//           byte[] arr = new byte[20];
//
//         int len;
//         while((len=is.read(arr))!=-1){
//             System.out.print(new String(arr,0,len));
//         }
//
//        is.close();

        testFileReader();
    }

    public static void testFileReader() throws IOException {

        new File("");



        FileReader fr = new FileReader("../text.txt");

        int len=0;
        char[] ch=new char[5];
        while((len=fr.read(ch))!=-1){
            System.out.println(new String(ch,0,len));
        }

        fr.close();



    }

}
