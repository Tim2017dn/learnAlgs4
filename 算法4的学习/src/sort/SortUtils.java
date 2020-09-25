package sort;
public class SortUtils {

    //显示是否排序
    public static void isSort(int[] arr) {
        boolean flag=true;
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i]>arr[i+1]) {
                flag= false;
                break;
            }
        }
        if(flag) {
            System.out.println("已排序");
        }else {
            System.out.println("未排序");
        }

    }

    //遍历
    public static void traversal(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //交换位置
    public static void swap(int[] arr,int s1,int s2) {
        int temp=arr[s1];
        arr[s1]=arr[s2];
        arr[s2]=temp;
    }



    public static void isSort(Comparable[] arr) {
        boolean flag=true;
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i].compareTo(arr[i+1])>0) {
                flag= false;
                break;
            }
        }
        if(flag) {
            System.out.println("已排序");
        }else {
            System.out.println("未排序");
        }

    }

    public static void traversal(Comparable[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //交换位置
    public static void swap(Comparable[] arr,int s1,int s2) {
        Comparable temp=arr[s1];
        arr[s1]=arr[s2];
        arr[s2]=temp;
    }

}