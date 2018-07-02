/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字符串.单词查找树;

/**
 * 
 * @author Earl_iu
 * 
 * 单词查找树：
 *  对于一个单词查找树，每个结点都含有一个链接数组，一个256位的数组，里面保存的就是相对应的字符
 *  由于长单词会在查找树中占用大量空间，其中包含了大量的空链接，我们不使用该算法用于大型字母表的大量长键
 */
public class TrieST {
    private static int R = 256;
    private Node root;  // 单词树的根节点
    
    private static class Node{
        private Integer val;
        private Node[] next = new Node[R];
    }
    
    public Integer get(String key){
        Node x = get(root,key,0);
        if(x==null){
            return null;
        } 
        return x.val;
    }
    
    private Node get(Node x, String key, int d){
        // 返回以x作为根结点的子单词查找树中与key相关联的值
        if(x==null) return null;
        if(d== key.length()) return x;
        char c = key.charAt(d);     // 找到第d个字符所对应的子单词查找树
        return get(x.next[c],key,d+1);
    }
    
    public void put(String key, int val){
        root = put(root,key,val,0);
    }
    
    private Node put(Node x, String key,int val, int d){
        if(x == null) x = new Node();
        if(d == key.length()){
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key , val, d+1);
        return x;
    }
    
    // 找到给定字符串的最长键前缀
    
    public String longestPrefixOf(String s){
        int length = search(root, s , 0,0);
        return s.substring(0,length);
    }
    
    private int search(Node x, String s, int d, int length){
        if(x==null) return length;
        if(x.val != null) length = d;
        if(d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c],s, d+1, length);
    }
    
    /*
    如果删除结点的链接不为空
        让该结点的值为null即可
    如果它的所有链接都是空
        删除这个结点
        检查这个结点的父结点的链接是否为空
            如果为空，删去父结点，并递归向上判断
            不为空则结束递归
    */
    public void delete(String key){
        root = delete(root,key,0);
    }
    
    private Node delete(Node x, String key, int d){
        if(x==null) return null;
        if(d==key.length()){
            x.val = null;
        }
        else{
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c],key,d+1);
        }
        if(x.val != null) return x;     // 该结点是否有值，如果有值就直接返回
        for(char c = 0; c<R;c++){       // 如果结点没有值，并且它的子结点都是null的话，即它也并没有子结点，这个结点就没有存在的意义了
            if(x.next[c] != null) return x;
        }
        return null;
    }
    
    public static void main(String args[]){
        TrieST s1 = new TrieST();
        s1.put("happy",1);
        s1.put("sad", 2);  
        s1.delete("sad");
        System.out.println(s1.get("sad"));
        
    }
}

