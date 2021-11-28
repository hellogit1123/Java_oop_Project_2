package com.mycompany.pizzaapp;

/**
 *
 * @author admin
 */
public interface MyIterator 
{
    Pizza next();
    boolean hasNext(); 
    void resetIndex();
}
