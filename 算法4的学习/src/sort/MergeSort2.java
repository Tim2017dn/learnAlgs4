package sort;

public class MergeSort2 {

    public static void main(String[] args) {

        int[] arr= {5,9,3,7,2,3,10,15,4};
        int[] dup=new int[arr.length];
        MergeSort2 s=new MergeSort2();
        s.sort(0,arr.length-1,arr);
        SortUtils.traversal(arr);
        SortUtils.isSort(arr);

    }

    public static void sort(int start,int stop,int[] arr){
        if(start>=stop){
            return;
        }
        int mid = (start+stop)/2;
        sort(start,mid,arr);
        sort(mid+1,stop,arr);

        merge(start,mid,stop,arr);

    }


    public static void merge(int start,int mid,int stop,int[] arr){
        int[] dup = new int[arr.length];

        int l = start;
        int r = mid+1;

        for(int k= start;k<=stop;k++){

            if(l == mid+1){
                dup[k] = arr[r];
                r++;
            }else if(r== stop+1){
                dup[k] = arr[l];
                l++;
            }else if(arr[l]<arr[r]){
                dup[k] = arr[l];
                l++;
            }else{
                dup[k] = arr[r];
                r++;
            }
        }

        for(int k=start;k<=stop;k++){
            arr[k] = dup[k];
        }


    }



}
