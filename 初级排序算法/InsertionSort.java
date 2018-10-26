/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 初级排序算法;

/*
* 直接插入排序    
* 每次用我们要插入的元素与之前的做比较，如果之前的比现在的大，我们将之前的那个元素往后放一位，第一次的时候就会把我们要插入元素的位置给补上
* 直到我们找到一个元素比要插入元素小的，我们就在它底下一个位置填入插入元素
* O(N2)
*/
public class InsertionSort {
    public static void insert(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int temp = arr[i];
            int ex = i-1; 
            while(ex>=0 && temp<arr[ex]){
                arr[ex+1] = arr[ex];
                ex--;
            }
            arr[ex+1] = temp;           
        }
    }
    
    
    public static void main(String args[]){
        int[] arr = {7,2,4,6,5,9,3};
        insert(arr);
        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
