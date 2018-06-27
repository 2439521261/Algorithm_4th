/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字符串;

/**
 *
 * @author Earl_iu
 * 
 * 当需要排序的字符串长度相同时，低位优先的字符串排序，基于键索引计数法，从左往右，不断比较对应位置的字符，并排序
 */
public class LSD {
    public static void sort(String[] a, int W){
        // 通过前W个字符将a[]排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        
        for(int d = W-1;d>=0;d--){
            int[] count = new int[R+1]; 
            // 根据第d个字符用键索引计数法排序
            for(int i =0;i<N;i++){
                count[a[i].charAt(d)+1]++;  // 计算出现频率
            }
            for(int j = 0;j<R;j++){
                count[j+1] += count[j];     // 将频率转换成索引
            }
            for(int i = 0;i<N;i++){
                aux[count[a[i].charAt(d)]++] = a[i];    // 将元素分类
            }
            for(int i=0;i<N;i++){
                a[i] = aux[i];          // 回写
            }
            
        }
    }
}
