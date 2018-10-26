/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;

/**
 * 将集合中第一个元素和后面的元素作比较，将最小的放在第一个，以此类推，总是将剩余集合中最小的元素放在最前面
 * O(N2)
 */

public class SelectionSort {
    
    public static void sort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String args[]){
        int[] arr = {2,7,4,6,5,9,3};
        sort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
