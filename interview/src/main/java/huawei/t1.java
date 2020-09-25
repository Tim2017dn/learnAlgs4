package huawei;

public class t1 {

    public static void main(String[] args) {

        System.out.println(f1(3));
        System.out.println(f2(3));
    }


    public static int f1(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }

        return f1(n-1)+f1(n-2);
    }

    public static int f2(int n){

        int[] dp = new int[n+1];

        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}



