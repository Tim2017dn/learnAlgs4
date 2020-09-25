package UFPackage;

public class QuickFindUF_Self {

    private int[] id;
    private int count;

    public QuickFindUF_Self(int n){
        this.count = n;
        this.id = new int[n];
        for(int i=0; i<n; this.id[i] =i++) {}
    }

    public int count(){return count; }

    public int find(int p){
//        this.
        return 0;
    }

    private void validate(int p) {
        int n = this.id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

}
