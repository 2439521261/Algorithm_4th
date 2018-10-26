package 背包;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author Earl_iu
 */
public class Bag {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bags<Integer> a = new Bags<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        Iterator<Integer> b = a.iterator();
        while(b.hasNext()){
            System.out.println(b.next());
        }
    }
    
}

class BagNode<Item>{
    Item item;
    BagNode<Item> next;
}



class Bags<Item> implements Iterable{
    private int size;
    private BagNode<Item> first;
    
    
   
    
    Bags(){
        first = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return first == null;        
    }
    
    public void add(Item item){
      
        BagNode<Item> OldFirst = first;
        first = new BagNode<Item>();
        first.item = item;
        first.next =OldFirst;
        size++;
        
    }
    
     public Iterator iterator()
    {
        // TODO Auto-generated method stub
        return new BagIterator();
    }
     
    private class BagIterator implements Iterator<Item>
    {   
        BagNode<Item> node = first;
        
        @Override
        public boolean hasNext()
        {
            // TODO Auto-generated method stub
            return node != null;
        }

        @Override
        public Item next()
        {
            // TODO Auto-generated method stub
            Item item = (Item) node.item;
            node = node.next;
            return item;
        }

    }
    
}