/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 动态规划;

/**
 *
 * @author Earl_iu
 * 
 * 15.1 钢条切割问题：
 *  公司出售一段长度为i英寸的钢条，不同长度，价格不同，如何切割收益最大
 */
public class RodCutting {
    public static void main(String args[]){
        int[] p = {0,1,5,8,9,10,17,17,20,24,30};
        int op = down_top_memo(p,10);
        System.out.println(op);
    }
    
    // 自顶向下法
    public static int top_down(int[] p, int n){
        if(n==0){
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for(int i =1;i<=n;i++){         // 我们不断递归，寻找长度n-i的钢条的最大收益，寻找子问题的最优解
            q = Math.max(q,p[i]+top_down(p,n-i));
        }
        return q;
        /*
            这个方法的缺点是需要不断的求解已经解决的子问题，递归展开导致工作量的大量上升
        */
    }
    
    // 带备忘录的自定向下法
    public static int memo(int[] p,int n){
        int[] r = new int[p.length+1];
        for(int i =0; i<p.length+1;i++){        // r是一个备忘录
            r[i] = -1;
        }
        return top_down_memo(p,n,r);
    }
    
    public static int top_down_memo(int[] p,int n,int[] r){
        // 对之前的top_down进行优化，将不同长度的最优收益存放至一个数组中，如果出现重复的问题，直接从数组中调用，Top-down with memoization
        if(r[n]>0){
            return r[n];    // 在初始化的时候，r[n]被设置为-1，当我们第一次遇到r[n]的时候，我们计算并存放至数组中
        }
        if(n==0){
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for(int i =1;i<=n;i++){         // 我们不断递归，寻找长度n-i的钢条的最大收益，寻找子问题的最优解
            q = Math.max(q,p[i]+top_down_memo(p,n-i,r));
        }
        r[n] = q;       // 我们得到了长度为n时的最优解，并存入数组中，以便下回的提取
        return q;
    }
    
    // 自底向上法
    public static int down_top_memo(int[] p,int n){
        int[] r = new int[p.length+1];
        for(int i =1; i<=n;i++){ // 计算0-n中每一个值的最优解，并放入r数组，最后在i=n的时候，不断对比，得到最大值0
            int q = -1;
            for(int j=1;j<=i;j++){
                q = Math.max(q, p[j]+r[i-j]);
            }
            r[i] = q;
        }
        return r[n];
    }
}

