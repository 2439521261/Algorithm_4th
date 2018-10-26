/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;

/**
 * 
 * 
 */

public class Heap{
    public static void main(String agrs[]){
        int[] arr = {0,12,1,90,2,11,9,4,6,13,5,3,33};  
        sort(arr);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.println();
    }
    
    public static void sort(int[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)              // 这里的for循环的作用就是建立一个堆有序，每个结点都小于等于它的父结点，只需要对前1/2的结点操作，因为剩下的都是边缘的结点
            sink(pq, k, N);
        while (N > 1) {                             // 这里的while循环是不断的取最大的，然后将他放在堆的最后面，这样，当我们print的时候，就是升序的排序
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }
 
    private static void sink(int[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && pq[j-1]<pq[j]) j++;        // 这里需要-1的原因是我们的堆的构造开始是由1角标开始的，这样使得*2的值不为0，并且，这里是对堆的三个结点的排序，如果左孩子小于右孩子，而父又小于左孩子的话，那么我们就需要交换父和右孩子
            if (pq[k-1]>=pq[j-1]) break;             // 如果父大于等于两个孩子中大的那个的话，我们不需要交换
            exch(pq, k, j);
            k = j;
        }
    }
 

    static void exch(int[] pq, int i, int j) {
        int swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
}