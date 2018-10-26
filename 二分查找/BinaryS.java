/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 二分查找;

/**
 *
 * @author Earl_iu
 */
public class BinaryS {
    
    private static int BinarySearch(int[] arr, int key, int low, int high){
        
        int middle = (low+high)/2;
        
     
        
        if(arr[middle] > key){
            return BinarySearch(arr,key,low,middle-1);
        }else if(arr[middle]<key){
            return BinarySearch(arr,key,middle+1,high);
        }else{
            System.out.println(middle);
            return middle;
        }
    }
    
    
    public static void main(String args[]){
        int[] arr = new int[5];
        arr[0] =0;
        arr[1]=5;
        arr[2] = 7;
        arr[3] = 10;
        int high = arr.length-1;
        BinarySearch(arr,5,0,high);
    }
    
}

