/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字符串.字符串排序;

/**
 *
 * @author Earl_iu
 * 快速排序的三向切分与高位优先MSD算法的结合
 */
public class Quick3string {
    private static int charAt(String s, int d){ // d判断的是我们根据字符串的第几个位为基础进行排序
        if(d < s.length())
            return s.charAt(d);
        else
            return -1;
    }
    
    public static void sort(String[] a){
        sort(a,0,a.length-1,0);
    }
    
    private static void sort(String[] a, int lo, int hi, int d){
        if(hi<=lo) return;
        int lt = lo;
        int gt = hi;
        int v = charAt(a[lo],d);
        int i = lo +1;      // 详细原理见快速排序
        while(i<=gt){
            int t = charAt(a[i],d);
            if(t<v){
                String temp = a[lt];
                a[lt] = a[i];
                a[i] = temp;
                i++;
                lt++; 
                
            }else if(a[i] == a[lt]){
                i++;
            }else{
                String temp = a[gt];
                a[gt] = a[i];
                a[i] = temp;
                gt--;
            }
        }
        sort(a,lo,lt-1,d);  // 小于pivot的字符串的递归
        if(v>=0) sort(a,lt,gt,d+1);     // 对于前面字符都相同的处理，我们对几个字符串中，接下来的部分进行排序
        sort(a,gt+1,hi,d);
        
    }
    
}
