package NetEase;

import java.util.Scanner;

public class t4 {

    public static int []x=new int [100005];

    public static void main(String[] args)
    {
        Scanner S=new Scanner(System.in);
        String s=S.nextLine(); int l=s.length();
        int a=0,b=0,c=0,d=0,e=0,f=0,ans=0;
        for(int i=0;i<=64;i++) x[i]=-1; x[0]=0;
        for(int i=0;i<l;i++)
        {
            char p=s.charAt(i);
            if(p=='a') a++; else if(p=='b') b++;
            else if(p=='c') c++; else if(p=='x') d++;
            else if(p=='y') e++; else if(p=='z') f++;
            a%=2; b%=2; c%=2; d%=2; e%=2; f%=2;
            int nw=32*a+16*b+8*c+4*d+2*e+f;
            int tmp=x[nw];
            if(tmp==-1) x[nw]=tmp;
            else ans=Math.max(ans,i-tmp+1);
        }
        System.out.println(ans);
    }
}
