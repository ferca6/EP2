/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr4;

import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author godof
 */
public class ShoppingCartTest {
    
    public ShoppingCartTest() {
          
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
              
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBalance method, of class ShoppingCart.
     * EJ 6
     */
    @Test
    public void testGetBalance() {
        System.out.println("Test de getBalance");
        ShoppingCart instance = new ShoppingCart();
        double result = instance.getBalance();
        assertEquals(0.0, result,0.0);
        instance.addItem(new Product("test1", 4.50));
        instance.addItem(new Product("test2", 1.50));
        result = instance.getBalance();
        assertEquals(6.0, result,0.0);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class ShoppingCart.
     * ej 7
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Product p = null;
        ShoppingCart instance = new ShoppingCart();
        assertEquals(0, instance.getItemCount());
        instance.addItem(p);
        assertEquals(1, instance.getItemCount());
        instance.empty();
        p =new Product("test1", 4.50);
        instance.addItem(p);
        instance.addItem(p);
        assertEquals(2, instance.getItemCount());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * Test of removeItem method, of class ShoppingCart.
     * ej 9
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveItem() throws Exception {
        System.out.println("removeItem");
        ShoppingCart instance = new ShoppingCart();
        try{
            instance.removeItem(null);
            fail("Debe saltar excepcion");
        }catch(Exception e){
            //funciona correctamente
        }
        assertEquals(0, instance.getItemCount());

        Product p =  new Product("Nuevo", 0);
        instance.addItem(p);
        try{
            instance.removeItem(p);
        }catch(Exception e){
            fail("error, no deberia saltar excepcion");
        }
        assertEquals(0, instance.getItemCount());
        
        instance.addItem(new Product("test1",2.5));
        p = new Product("test2",3.0);
        try{
            instance.removeItem(p);
            fail("Debe saltar excepcion");
            
        }catch(Exception e){
            //funciona correctamente
        }
        assertEquals(1, instance.getItemCount());
        
         instance.addItem(new Product("test3",6.0));
        try{
            instance.removeItem(new Product("test3",6.0));
            
        }catch(Exception e){
            fail("error, no deberia saltar excepcion!");
        }
        assertEquals(1, instance.getItemCount());
    }

    /**
     * Test of getItemCount method, of class ShoppingCart.
     * EJ 11
     */
    @Test
    public void testGetItemCount() {
        System.out.println("getItemCount");
        ShoppingCart instance = new ShoppingCart();
        assertEquals(0, instance.getItemCount());
        
        instance.addItem(new Product("test1", 0.50));
        instance.addItem(new Product("test2", 1.50));
        
        assertEquals(2, instance.getItemCount());
        
        try {
            instance.removeItem(new Product("test2", 1.50));
        } catch (ProductNotFoundException ex) {
            Logger.getLogger(ShoppingCartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, instance.getItemCount());
    }

    /**
     * Test of empty method, of class ShoppingCart.
     * ej 14
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        ShoppingCart instance = new ShoppingCart();
        instance.empty();
        assertEquals(true,instance.isEmpty());
        assertEquals(0,instance.getItemCount());
        instance.addItem(new Product("test1", 0.50));
        instance.addItem(new Product("test2", 1.50));
        instance.empty();
        assertEquals(true,instance.isEmpty());  
        assertEquals(0,instance.getItemCount());
    }

    /**
     * Test of isEmpty method, of class ShoppingCart.
     * Ej 15
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ShoppingCart instance = new ShoppingCart();
        assertEquals(true, instance.isEmpty());
        assertEquals(0,instance.getItemCount());
        instance.addItem(new Product("test1", 0.50));
        instance.addItem(new Product("test2", 1.50));
        instance.empty();
        assertEquals(true,instance.isEmpty()); 
        assertEquals(0,instance.getItemCount());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * @throws java.lang.Exception
     * Test of imprimeFactura method, of class ShoppingCart.
     */
    @Test
    public void testImprimeFactura() throws Exception {
        
    }

    /**
     * Test of findProduct method, of class ShoppingCart.
     * ej 16
     */
    @Test
    public void testFindProduct() {
        System.out.println("findProduct");
        ShoppingCart instance = new ShoppingCart();
        assertEquals(false, instance.findProduct("aaaa"));
        Product p = new Product("test1", 0.50);
        instance.addItem(p);
        assertEquals(true, instance.findProduct(p.getTitle()));
        try {
            instance.removeItem(p);
        } catch (ProductNotFoundException ex) {
            Logger.getLogger(ShoppingCartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(false, instance.findProduct(p.getTitle()));
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");*/
    }
    
    /**
     * Ej 8
     */
    @Test
    public void testAddItemFindProduct(){
        ShoppingCart instance = new ShoppingCart();
        assertFalse(instance.findProduct(""));
        instance.addItem(new Product("Nuevo", 0));
        assertTrue(instance.findProduct("Nuevo"));
        instance.addItem(new Product("", 2.0));
        assertTrue(instance.findProduct(""));
        // TODO review the generated test code and remove the default call to fail.
        //*/
    }
    
    /**
     * Ej 10
     * @throws Exception 
     */
    @Test
    public void testRemoveItem2()throws Exception{
       System.out.println("removeItem");
        Product p =  new Product("Nuevo", 0);
        ShoppingCart instance = new ShoppingCart();
        instance.addItem(p);
        assertTrue(instance.findProduct(p.getTitle()));
        instance.removeItem(p);
        assertEquals(0, instance.getItemCount());       
    }
    
    /**
     * Ej 11
     * @throws Exception 
     */
    @Test
    public void testRemoveItemCarroVacio() throws Exception{
        System.out.println("removeItem");
        Product p =  new Product("Nuevo", 0);
        ShoppingCart instance = new ShoppingCart();
        assertTrue(instance.isEmpty());
        assertTrue(!instance.findProduct(p.getTitle()));
        try{
            instance.removeItem(p);
            fail("Debe lanzarse excepcion!");
        }catch(Exception e){
            //funciona correctamente
        }
    }
    
    /**
     * Ej 13
     */
    @Test
    public void testConstructor() {
        System.out.println("constructor");
        ShoppingCart instance = new ShoppingCart();
        assertEquals(true,instance.isEmpty());
        assertEquals(0.0,instance.getBalance(),0.0);
        assertEquals(0,instance.getItemCount());
    }
    
        
        
}
