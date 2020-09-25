package sort;

public class Quick3Way {

    public static void main(String[] args) {

        Integer[] arr= {1,9,3,7,2,3,10,15,4,1,3,4,9,7,3};

        Quick3Way s=new Quick3Way();
        s.sort(arr,0,arr.length-1);
        SortUtils.traversal(arr);
        SortUtils.isSort(arr);
    }

    public static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo){return;}
        // 取第一个元素作为判断的
        Comparable v = a[lo];
        int lt = lo;
        int i = lt+1;
        int gt = hi;
        while(i<=gt){
            Comparable cur = a[i];
            int cmp = cur.compareTo(v);
            if(cmp<0){
                swap(a, lt++, i++);
            }else if(cmp > 0){
                swap(a, i, gt--);
            }else{
                i++;
            }
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
        
    }

    public static void swap(Comparable[] a,int i,int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
