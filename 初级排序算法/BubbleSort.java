/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;

/**
 * 冒泡排序
 * 两两作对比，总是把最大的放在后面，不断缩小问题规模
 * O(N2)
 */
public class BubbleSort {
    public static void BubbleSort(int[] arr){
        for(int i =0;i<arr.length-1;i++){
            for(int j =0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void main(String args[]){
        int[] arr = {2,7,4,6,5,9,3};
        BubbleSort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
