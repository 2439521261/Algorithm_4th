/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;

/**
 *  归并排序：O(N*lgN),总共需要划分数组lgN次，每次都需要对全部数组进行一次比较操作，即N次，所以为NlgN
 *  归并排序分为两步，递归地将数组分为两份，分别排序，然后将结果归并起来
 *  原地归并：普通的归并算法，每次归并时都是产生一个新的数组来储存排序结果，但是这样就会产生不必要的额外空间，原地归并就是只用两个数组，使用index来进行比较，对数组进行排序
 *  进一步优化：我们对长度小于7的子数组使用插入排序而不是merge方法时，会使算法变快
 * 
 */
public class MergeSort {
    public static void main(String args[]){
        int[] arr = {0,12,1,90,2,11,9,4,6,13,5,3,33};  
        sort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.println();
    }
    
  
    
    public static void merge(int[] arr, int[] aux, int lo, int mid, int hi){
        
        int i = lo;     // 对前半段数组的index追踪
        int j = mid+1;  // 对后半段数组的index追踪
        
        for(int k = lo;k<=hi;k++){
            aux[k] = arr[k];        // 复制数组
        }
        
        
        for(int k = lo;k<=hi;k++){
            if(i>mid){              // 当左边的元素取尽，即追踪角标超过左边数组长度了，接下来填充的肯定只能是右边的元素了
                arr[k] = aux[j++];
            }else if (j>hi){        // 当右边取尽
                arr[k] = aux[i++];
            }
            else if (aux[i]>aux[j]){    // 左边的值比右边的大的时候，原数组中这个位置填充右边的值
                arr[k] = aux[j++];
            }else{      // 当右半边当前元素大于左半边当前元素时，我们取左边元素
                arr[k] = aux[i++];
            }
        }  
    }
    
    public static void sort(int[] arr, int[] aux, int lo,int hi){
        if(lo>=hi) return;
        int mid = lo + (hi-lo)/2;
        sort(arr,aux,lo,mid);
        sort(arr,aux,mid+1,hi);
        merge(arr,aux,lo,mid,hi);
    }
    public static void sort(int[] arr){
        int[] aux = new int[arr.length];
        sort(arr,aux,0,arr.length-1);
    }
}
