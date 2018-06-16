/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 树;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Earl_iu
 */
public class BinaryTree{
    public static void main(String args[]){
       BinaryTree bt = new BinaryTree();
       bt.put(7, "7");
       bt.put(5,"5");
       bt.put(3,"3");
       bt.preOrder();
    }
    
    public Node root;
    public static List<Integer> a = new ArrayList();
    
    private class Node{
        private int key;
        private String val;
        private Node left,right;
        private int total;
        
        public Node(int key, String val,int total){
            this.key = key;
            this.val = val;
            this.total = total;
        }
    }
    
    public int size(){
        return(size(root));
    }
    
    private int size(Node x){
        if(x==null) return 0;
        else return x.total;
    }
    
    public String get(int key){
        return(get(root,key));
    }
    
    private String get(Node x, int key){
        if(x==null) return null;
        if(key>x.key){
            return(get(x.right,key));
        }else if(key<x.key){
            return(get(x.left,key));
        }else{
            return x.val;
        }
    }
    
    public String get_iter(int key){
        Node x = root;
        while(x!=null){
            if(key>x.key){
                x = x.right;
            }else if(key<x.key){
                x = x.left;
            }else{
                return x.val;
            }
        }
        return null;     
    }
    
    public void put(int key, String val){
        root = put(root, key,val);
    }
    
    private Node put(Node x, int key, String val){
        if(x==null) return(new Node(key,val,1));
        if(key<x.key){
            x.left = put(x.left,key,val);
        }else if(key>x.key){
            x.right = put(x.right,key,val);
        }else{
            x.val = val;
        }
        x.total = size(x.left)+size(x.right)+1;
        return x;
    }
    
    public int min(){
        return min(root).key;   
    }
    
    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }
    public int max(){
        return max(root).key;
    }
    
    private Node max(Node x){
        if(x.right ==null) return x;
        return max(x.right);
    }
    
    public int floor(int key){
        Node x = floor(root,key);
        if (x == null){
            return -1;
        }
        return x.key;
        
    }
    
    private Node floor(Node x, int key){     // 向下取整，找到大于等于x的最小整数
        if(x==null) return null;
        if(key<x.key){
            return floor(x.left,key);
        }
        else if(key == x.key){
            return x;
        }else{
            Node t = floor(x.right,key);
            if(t!=null){
                return t;
            }else{
                return x;
            }
        }
    }
    
    public int select(int k){
        return select(root,k).key;
    }
    
    private Node select(Node x, int k){             // select是找出树中正好排名为k的键，即树中有k个小于他的键
        if(x == null) return null;
        int t = size(x.left);
        if(t<k){                                    // 左子树的size大于k的话，我们接着往左走，不断找到k个元素
            return select(x.right,k-t-1);
        }else if(t>k){                              // 左子树的size小于k，说明左边的元素不够，我们从右边找，对于一个结点右边的键肯定比左边的大
            return select(x.left,k);
        }else{
            return x;
        }
    }
    public int rank(int key){
        return rank(key, root);
    }
    private int rank(int key, Node x){
        if(x==null) return 0;
        if(key<x.key){
            return rank(key,x.left);
        }else if(key>x.key){
            return(1+size(x.left)+rank(key,x.right));
        }else{
            return size(x.left);
        }
    }
    
    public void deleteMin(){
        root = deleteMin(root);
    }
    
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.total = size(x.left) + size(x.right) +1;
        return x;
    }
    
    public void delete(int key){
        root = delete(root,key);
    }
    
    private Node delete(Node x, int key){
        if(x==null) return null;
        if(key>x.key){
            x.right = delete(x.right,key);
        }else if(key<x.key){
            x.left = delete(x.left,key);
        }else{
            if(x.right == null){
                return x.left;
            }
            if(x.left == null){
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.total = size(x.left) + size(x.right) +1;
        return x;
    }
    
    public void preOrder(){
        preOrder(root);
    }
    
    public void preOrder(Node x){           // 中序排序 中左右;
        System.out.println(x.key);
        if(x.left !=null){
            preOrder(x.left);
        }
        if(x.right!=null){
            preOrder(x.right);
        }
    }
}
