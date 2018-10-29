/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 动态规划;

/**
 * @author Earl_iu
 * 最长公共子序列
 * 对于一个公共子序列X={x1,x2,x3...xm},Y={y1,y2,y3....yn},Z是X和Y的任意一个LCS {z1,z2,z3...zk}
 */
public class commonSubsequence {
    public static void main(String args[]){
        String a = "1A2C3D4B56";
        String b = "B1D23CA45B6A";
        int al = 10;
        int bl = 12;
        int c = longest(a,al,b,bl);
        System.out.println(c);
    }
    
    public static int longest(String A, int n, String B, int m){
        int[][] list = new int[n+1][m+1];
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(A.charAt(i-1) == B.charAt(j-1)){ // 如果A[i] = B[j]，那么LCS的最后一个必然就是该值，我们可以将长度+1，并求Xm-1和Yn-1的一个LCS
                    list[i][j] = list[i-1][j-1]+1;
                }else{      // 但是如果不同的话，我们必然想要得到LCS长的那个
                    list[i][j] = Math.max(list[i][j-1],list[i-1][j]);
                }
            }
        }
        return list[n][m]; 
    }
}
