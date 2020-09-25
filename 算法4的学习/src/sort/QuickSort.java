package sort;

public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr= {1,9,3,7,2,3,10,15,4};
        int[] dup=new int[arr.length];
        QuickSort s=new QuickSort();
        s.sort(arr);
        SortUtils.traversal(arr);
        SortUtils.isSort(arr);
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    public void sort(int[] arr,int low,int high) {
        if(high<=low) {
            return ;
        }
        int j=partition(arr, low, high);
        sort(arr,low,j-1);
        sort(arr, j+1, high);
    }

    public static int partition(int[] arr,int low,int high) {
        int i=low+1;
        int j=high;
        int v=arr[low];
        while(i<j) {
            while(arr[i]<v) {
                i++;

            }
            while(arr[j]>v) {
                j--;
            }

            if(i>=j) {break;}
            SortUtils.swap(arr,i, j);
        }

        SortUtils.swap(arr, low, j);
        return j;

    }


}
