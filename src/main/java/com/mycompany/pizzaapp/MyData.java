package com.mycompany.pizzaapp;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class MyData 
{
    private premade_pizzas pre = new premade_pizzas();
    private ArrayList<Pizza> p = pre.get_data();
    private int index = 0;
    private int size = p.size();
    
    private static class Iterate implements MyIterator
    {
        private final MyData data;
        private int index;
        private int size;
        
        public Iterate(MyData data)
        {
            this.data = data;
            this.index = 0;
            this.size = data.p.size();
        }
        
        public boolean hasNext()
        {
            if(index<size)
                return true;
           return false; 
        }
        
        public String next()
        {
            if(hasNext())
                return data.p.get(index++).pizzaInfo();
            return "null\n\n";
        }
        
        public void resetIndex()
        {
            this.index = 0;
        }
    }
    
    public MyIterator iter()
    {
        return new Iterate(this);
    }
}
