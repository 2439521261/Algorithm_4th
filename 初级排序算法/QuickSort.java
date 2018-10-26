/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;

/**
 * 快速排序：O(NlgN)
 * 
 * 快速排序的时候，必须从右边开始，如果先从左边开始，例如，6,1,2,7,9，从左边开始，找到了一个比pivot大的值，就是7，从右边开始找一个比pivot小的值，可是不能超过6，找不到，我们就用6和7交换，这样是错误的
 * 基于快速排序的优化：
 *  1.对小数组，快速排序比插入排序慢
 *  2.三向切分的快速排序, 将数组分为三份，大于，等于和小于
 *  3.在算法开始的时候，需要对整个数组做一次shuffle随机打乱，因为当数组中有大量有序部分的时候，每次的sort只能使待排序列减1，此时为最坏的情况，O(N2)
 */
public class QuickSort {
    public static void main(String args[]){
        int[] arr = {12,11,1,91,11,11,18,13};
        tri_sort(arr,0,arr.length-1);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
    }
    
    public static void tri_sort(int[] arr, int left, int right){
        if(left>=right) return;
        int lt = left;
        int gt = right;
        int i = left +1;
        int comp = arr[left];
        while(i<=gt){                                       // lt跟踪了比comp小的数，gt跟踪了比comp大的数，lt与i-1之间是与comp相等的数，i到gt之间的数是未确定的
            if(arr[i]<comp){                                // a[i]小于comp的时候，将a[lt]与a[i]交换，lt与i都加1，a[lt]就是comp
                int temp = arr[lt];
                arr[lt] = arr[i];
                arr[i] = temp;
                i++;
                lt++;
            }else if(arr[i] == arr[lt]){
                i++;
            }else{                                          // a[i]大于comp的时候，a[gt]和a[i]交换，将gt-1
                int temp = arr[gt];
                arr[gt] = arr[i];
                arr[i] = temp;
                gt--;
            }
        }
        sort(arr,left,lt-1);
        sort(arr,gt+1,right);
        
    }

    public static void sort(int[] arr, int left, int right){
        if(left>=right)   return;
        int i = left;
        int j = right;
        int pivot = arr[left];
        
        while(i<j){
            while(pivot<=arr[j]&&i<j)   // 在这里必须是<=
               j--;
            while(pivot>=arr[i]&&i<j)   // 这里必须是>=，因为当开始从pivot开始的，12不大于12，这样就做了一个无用的交换，导致赋值的错误
               i++;  
           if(i<j)                     //如果i<j，交换它们
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        arr[left] = arr[i];
        arr[i]= pivot;//把基准值放到合适的位置
        sort(arr,left,i-1);
        sort(arr,i+1,right);
    }
}
