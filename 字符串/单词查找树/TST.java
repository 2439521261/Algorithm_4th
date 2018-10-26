/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 字符串.单词查找树;

/**
 *
 * @author Earl_iu
 * 三向单词查找树
 */
public class TST {
    private Node root;
    
    private class Node{
        char c;
        Node left, mid, right;
        Integer val;
    }
    
    public Integer get(String key){
        Node x = get(root,key,0);
        if(x == null) return null;
        return x.val;
    }
    
    private Node get(Node x, String key, int d){
        if(x == null) return null;
        char c = key.charAt(d);
        if (c<x.c) return get(x.left,key,d);                // 如果查找未命中，且键小于结点，则向左寻找，如果大于，则向右寻找，
        else if(c>x.c) return get(x.right,key,d);       
        else if(d<key.length()-1)
            return get(x.mid,key,d+1);                     // 如果字符等于该结点的话，则查找命中，我们从从中间向下寻找，并且d+1
        else
            return x;
    }
}
