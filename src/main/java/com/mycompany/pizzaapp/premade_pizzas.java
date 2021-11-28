package com.mycompany.pizzaapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class premade_pizzas 
{
    private ArrayList<Pizza> a = new ArrayList<Pizza>();
    premade_pizzas()
    {
        try {
            this.load_data();
        } catch (FileNotFoundException ex) {
            System.out.println("load data didn't work");
            Logger.getLogger(premade_pizzas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void load_data() throws FileNotFoundException
    {
        database db = new txt_db();
        a = db.read();
    }
    
    private ArrayList get_data()
    {    
        return this.a;
    }
    
    private static class Iterate implements MyIterator
    {
        private final premade_pizzas data;
        private int index;
        private int size;
        
        public Iterate(premade_pizzas data)
        {
            this.data = data;
            this.index = 0;
            this.size = data.a.size();
        }
        
        public boolean hasNext()
        {
            if(index<size)
                return true;
           return false; 
        }
        
        public Pizza next()
        {
            return data.a.get(index++);
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
