/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字符串.字符串排序;

import edu.princeton.cs.algs4.Insertion;

/**
 *
 * @author Earl_iu
 * 高位优先的字符串排序，通用的字符串排序算法，字符串的长度不一样
 */
public class MSD {
    private static int R = 256;
    private static String[] aux;
    
    private static int charAt(String s, int d){
        if(d<s.length()){
            return s.charAt(d);
        }
        else{
            return -1;  // 当指定位置超过了字符串的末尾时，返回-1
        }
    }
    
    public static void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a,0,N-1,0);
    }
    
    private static void sort(String[] a,int lo, int hi, int d){
        /*
        优化：
        
        1.在做优化的时候，我们可以规定一个阈值M，对长度小于M的字符串使用插入排序，在使用基础的排序方法时，我们会大量地生成新的小型数组，这会使得整个算法的效率变低
        对于MSD这种优化是必须的
        
        if(hi<=lo+15){
            Insertion.sort(a,lo,hi,d);
            return;
        }
        
        2.我们可以对前d个字符相同的字符串使用插入排序，防止由于大量的相同数组导致的效率低下
        
         */
    
        int[] count = new int[R+2];
        for(int i = lo;i<=hi;i++){
            count[charAt(a[i],d)+2]++;  // 计算频率,为了保证统一，我们用index 1去储存指定位置超过字符串的末尾的情况
        }
        for(int r = 0; r < R+1; r++){       // 将频率转换成索引
            count[r+1] += count[r];
        }
        for(int i = lo;i<=hi;i++){
            aux[count[charAt(a[i],d)]++] = a[i];    // 数据分类
        }
        for(int i =lo;i<=hi;i++){
            a[i] = aux[i-lo];
        }
        
        for(int r = 0;r<R;r++){
            sort(a,lo+count[r],lo+count[r+1]-1,d+1);    // 递归地以剩余的每个字符为键去排序，例如，当d=2的时候，即在数组中对字符串的第三个字符排序，lo与hi规定的是，对于每个子数组，index 2以前的部分必须相同
        }
    }
}
