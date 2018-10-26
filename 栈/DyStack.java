/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 栈;

import java.util.Iterator;

/**
 *
 * @author Earl_iu
 */
public class DyStack {
    
    public static void main(String[] args) {
        Stack<Integer> a = new Stack<Integer>();
        a.push(1);
        a.push(1);
        a.push(1);
        a.push(1);
        Iterator<Integer> it = a.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}

class Stack<Item> implements Iterable<Item>
{
    private Item[] a = (Item[])new Object[1];
    private int N = 0;
    private void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for ( int i =0;i < N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        if(N==a.length){
            resize(a.length*2);
        }
        else
        {
            a[N++] = item;
        }
        
    }  
    public Item pop(Item item){
        Item staff =  a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4)
        {
            resize(a.length/2);
        }
        return staff;
    }
    public Iterator<Item> iterator(){
        return new New_iterator();   
    }
    
    public class New_iterator implements Iterator<Item>{
        public int i = N;
        public boolean hasNext(){
            return i >0;
        }
        public Item next(){
            return a[--i];
        }
    }
}
