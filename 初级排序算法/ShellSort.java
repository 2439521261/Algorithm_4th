/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;


/**
 * 希尔排序的基本描述：
 * 希尔排序内部可以使用冒泡排序或者选择排序，下面都是实现
 * 步长h代表着，将数组分成数个小份，每份有h个元素
 * 我们从第0号元素开始，与每隔h个元素的元素进行对比排序，例如，将a[i]与a[i-h]、a[i-2h]、a[i-3h]...排序
 * 不断缩小h的长度
 * O(N2)
 */
public class ShellSort {
    public static void ShellSort_insert(int arr[]){
        int h = 1; /* 关于步长，取值没有统一标准，必须小于arr.length，最后一次步长要为1 */  

        /* 计算首次步长 */  
        while (h < arr.length/3)  
            h = 3*h + 1;
            System.out.println("首次步长："+h);

       while (h >= 1) {
        /* 将a[i]与a[i-h]、a[i-2h]、a[i-3h]...使用冒泡排序 */
            for(int i = h;i<arr.length;i++){
                for (int j = i; j >= h; j -= h) {
                    if(arr[j] < arr[j-h]){
                        int temp = arr[j];  
                        arr[j] = arr[j-h];  
                        arr[j-h] = temp; 
                    }
                }  
            }
     
           
            
            
            /* 每轮内循环后输出数组的现状 */  
            for(int k =0;k<arr.length;k++){
                System.out.print(arr[k]);
            }
            System.out.println();
            /* 计算下一轮步长 */  
            h = h / 3;
            System.out.println("后续步长："+h);
        }  
  
    }
    
    public static void ShellSort_bubble(int arr[]){
        int h = 1; /* 关于步长，取值没有统一标准，必须小于arr.length，最后一次步长要为1 */  

        /* 计算首次步长 */  
        while (h < arr.length/3)  
            h = 3*h + 1;
            System.out.println("首次步长："+h);

          
         while (h >= 1) {  
            for (int i = h; i < arr.length; i++) {  
            /* 将a[i]与a[i-h]、a[i-2h]、a[i-3h]...使用选择排序 */
                int temp = arr[i];
                int ex = i-h; 
                while(ex>=0 && temp<arr[ex]){
                    arr[ex+h] = arr[ex];
                    ex = ex - h;
                }
                arr[ex+h] = temp;
            }  
            /* 每轮内循环后输出数组的现状 */  
            for(int k =0;k<arr.length;k++){
                System.out.print(arr[k]);
            }
            System.out.println();
            /* 计算下一轮步长 */  
            h = h / 3;
            System.out.println("后续步长："+h);
        }  
         
    }
    
    public static void main(String args[]){
        int[] arr1 = {8,4,3,7,9,0,1,5,6,2};
        ShellSort_insert(arr1);
        for(int i =0;i<arr1.length;i++){
            System.out.print(arr1[i]);
        }
        System.out.println();
    }
}
