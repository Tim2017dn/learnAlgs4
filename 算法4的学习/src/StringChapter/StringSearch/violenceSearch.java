package StringChapter.StringSearch;

public class violenceSearch {

    public static void main(String[] args) {
        String pat="aaab";
        String txt="aaaaaab";
        int res = search(pat, txt);
        System.out.println(res);

    }


    public static int search(String pat,String txt){
        int M=pat.length();
        int N=txt.length();

        for(int i=0;i<=N-M;i++){
            int j;
            for(j=0;j<M;j++){
                if(pat.charAt(j)!=txt.charAt(i+j)){
                    break;
                }
            }

            if(j==M){return i;}


        }
        return -1;

    }

}
