package sort;
public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr= {5,9,3,7,2,3,10,15,4};
        int[] dup=new int[arr.length];
        MergeSort s=new MergeSort();
        s.sort(arr,0,arr.length-1,dup);
        SortUtils.traversal(arr);
        SortUtils.isSort(arr);
    }


    public void sort(int[] arr,int start,int stop,int[] dup) {

        if(start>=stop) {
            return;
        }

        int mid=start+(stop-start)/2;
        sort(arr,start,mid,dup);
        sort(arr,mid+1,stop,dup);
        merge(arr, start, mid, stop, dup);
    }

    public void merge(int[] arr,int low,int mid,int high,int[] dup) {

        int left=low;
        int right=mid+1;

        for(int k=low;k<=high;k++) {
            if(left>mid) {
                dup[k]=arr[right];
                right++;
            }else if(right>high) {
                dup[k]=arr[left];
                left++;
            }else if(arr[left]<arr[right]) {
                dup[k]=arr[left];
                left++;
            }else {
                dup[k]=arr[right];
                right++;
            }
        }

        for(int k=low;k<=high;k++) {
            arr[k]=dup[k];
        }
    }

}