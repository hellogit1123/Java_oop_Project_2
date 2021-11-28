package com.mycompany.pizzaapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class premade_pizzas 
{
    private ArrayList<Pizza> a = new ArrayList<Pizza>();
    private ArrayList<String> s = new ArrayList<String>();
    private Pizza p;
    
    premade_pizzas()
    {
        System.out.println("im in premade_pizza constructor");
        try {
            this.load_data();
        } catch (FileNotFoundException ex) {
            System.out.println("load data didn't work");
            Logger.getLogger(premade_pizzas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void load_data() throws FileNotFoundException
    {
        System.out.println("im in load_data");
        database db = new txt_db();
        s = db.read();
        System.out.println("after db.read before loop");
        for(String str:s)
        {
            p = new Pizza();
            String[] parts = str.split(" ");
            p.setName(parts[0]);
            p.setSize(parts[1].charAt(0));
            p.addToppings(parts[2]);
            p.addToppings(parts[3]);
            p.setSauce(parts[4]);
            p.setPrice(Double.valueOf(parts[5]));
            a.add(p);
        }
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
