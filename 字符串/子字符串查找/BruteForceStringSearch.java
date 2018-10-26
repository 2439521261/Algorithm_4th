/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字符串.子字符串查找;

/**
 *
 * @author Earl_iu
 * 暴力子字符串查找算法
 */
public class BruteForceStringSearch {
    public static int search(String pat, String txt){
        int M = pat.length();
        int N = txt.length();
        for(int i=0;i<=N-M;i++){
            int j;
            for(j=0;j<M;j++){
                if(txt.charAt(i+j)!=pat.charAt(j))
                    break;
            }
            if(j==M)
                return i;   // 找到匹配
        }
        return N;   //未找到匹配
    }  
    
    /*
    如果i和j指向的字符不匹配了，那么需要回退这两个指针的值；将j重新指向模式的开头，将i指向本次匹配的开始位置的下一个字符
    */
    public static int search_back(String pat, String txt){
        int i;
        int j;
        int M = pat.length();
        int N = txt.length();
        for(i=0,j=0;i<N&&j<M;i++){
            if(txt.charAt(i) == pat.charAt(j))
                j++;
            else
                i -=j;
                j=0;
        }
        if(j==M)
            return i-M;     // 找到匹配
        else
            return N;       // 未找到匹配
    }
}
