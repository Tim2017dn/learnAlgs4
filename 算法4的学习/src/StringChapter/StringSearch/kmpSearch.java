package StringChapter.StringSearch;

public class kmpSearch {

    public static void main(String[] args) {
        String pattern = "ABABC";
        String txt = "ABCABABCAABB";
        kmp_Search(txt, pattern);

//        int[] prefix = getprefix(pattern);
//        moveRightOneSpace(prefix);
//        for(int i=0;i<prefix.length;i++){
//            System.out.print(prefix[i]+" ");
//        }
    }

    public static int[] getprefix(String pattern){

        int[] prefix=new int[pattern.length()];
        prefix[0] = 0;
        int len   = 0;
        int i     = 1;
        while( i < pattern.length() ){
        //    System.out.println(pattern.charAt(i)+" "+pattern.charAt(len));
            if( pattern.charAt(i) == pattern.charAt(len)){
                len++;
                prefix[i]=len;
                i++;
            }
            else{
                if(len > 0){
                    len = prefix[len-1];
                }else{
                    len=0;
                    i++;
                }
            }

        }
        return prefix;
    }


    public static void moveRightOneSpace(int[] arr){
        for(int i=arr.length-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=-1;
    }


    public static void kmp_Search(String txt,String pattern){

        // txt[i]       len = m
        // pattern[j]   len = n

        int[] prefix = getprefix(pattern);
        moveRightOneSpace(prefix);
        int i = 0;
        int j = 0;
        int m = txt.length();
        int n = pattern.length();

        while(i<m){
            if(j == n-1 && txt.charAt(i) == pattern.charAt(j)){
                System.out.println("found "+(i-j));
                j=prefix[j];
            }
            if(txt.charAt(i) == pattern.charAt(j)){
                i++;j++;
            }else{
                j=prefix[j];
                if(j == -1){
                    i++;j++;
                }
            }
        }

    }

}
