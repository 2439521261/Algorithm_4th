/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;

/**
 * 归并排序的自底向上的方法，从2个2个开始排序，然后4个4个的，不断的往上
 * 
 */
public class MergeSort_BottomUp {
	private static int[] aux;

	public static void merge(int[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (aux[j]<aux[i]) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	public static void sort(int[] a) {
		int N = a.length;
		aux = new int[N];
		for (int sz = 1; sz < N; sz = sz + sz) {
			for (int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
        }

	public static void main(String[] args) {
		int[] arr = {0,12,1,90,2,11,9,4,6,13,5,3,33};  
		sort(arr);
		for(int i =0;i<arr.length;i++){
                    System.out.print(arr[i]);
                    System.out.print(",");
                }
                System.out.println();
	}
}