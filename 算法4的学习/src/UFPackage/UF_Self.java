package UFPackage;

public class UF_Self {

    private int[] parent;
    private byte[] rank;
    private int count;


    public UF_Self(int n){

        if(n<0) throw new IllegalArgumentException();
        count = n;
        parent =new int[n];
        rank = new byte[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }


    public int find(int p){
        validate(p);
        while(p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }





    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }



}
