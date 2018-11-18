/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr4;

import java.io.Writer;
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
        ShoppingCart instance = new ShoppingCart();
        assertEquals(true,instance.isEmpty());        
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
     */
    @Test
    public void testGetBalance() {
        /*System.out.println("getBalance");
        ShoppingCart instance = new ShoppingCart();
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of addItem method, of class ShoppingCart.
     */
    @Test
    public void testAddItem() {
        /*System.out.println("addItem");
        Product p = null;
        ShoppingCart instance = new ShoppingCart();
        instance.addItem(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of removeItem method, of class ShoppingCart.
     */
    @Test
    public void testRemoveItem() throws Exception {
        /*System.out.println("removeItem");
        Product p =  new Product("Nuevo", 0);
        ShoppingCart instance = new ShoppingCart();
        instance.removeItem(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of getItemCount method, of class ShoppingCart.
     */
    @Test
    public void testGetItemCount() {
        System.out.println("getItemCount");
        ShoppingCart instance = new ShoppingCart();
        int expResult = 0;
        int result = (int)instance.getItemCount();
        assertEquals(expResult, result);
        instance.addItem(new Product("test1", 0.50));
        instance.addItem(new Product("test2", 1.50));
        expResult = 2;
        result = (int)instance.getItemCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

    }

    /**
     * Test of empty method, of class ShoppingCart.
     */
    @Test
    public void testEmpty() {
       System.out.println("empty");
        ShoppingCart instance = new ShoppingCart();
        instance.empty();
        assertEquals(true,instance.isEmpty());  
        instance.addItem(new Product("test1", 0.50));
        instance.addItem(new Product("test2", 1.50));
        instance.empty();
        assertEquals(true,instance.isEmpty());  
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ShoppingCart.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ShoppingCart instance = new ShoppingCart();
        assertEquals(true, instance.isEmpty());
        instance.addItem(new Product("test1", 0.50));
        instance.addItem(new Product("test2", 1.50));
        instance.empty();
        assertEquals(true,instance.isEmpty()); 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");*/
    }

    /**
     * Test of imprimeFactura method, of class ShoppingCart.
     */
    @Test
    public void testImprimeFactura() throws Exception {
        /*System.out.println("imprimeFactura");
        Writer writer = null;
        ShoppingCart instance = new ShoppingCart();
        instance.imprimeFactura(writer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of findProduct method, of class ShoppingCart.
     */
    @Test
    public void testFindProduct() {
        System.out.println("findProduct");
        ShoppingCart instance = new ShoppingCart();
        assertEquals(false, instance.findProduct("aaaa"));
        instance.addItem(new Product("test1", 0.50));
        assertEquals(true, instance.findProduct("test1"));
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");*/
    }
    
    @Test
    public void testAddItemFindProduct(){
        /*Product p = new Product("Nuevo", 0);
        ShoppingCart instance = new ShoppingCart();
        instance.addItem(p);
        instance.findProduct(p.getTitle());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
    @Test
    public void testRemoveItem2()throws Exception{
       /*System.out.println("removeItem");
        Product p =  new Product("Nuevo", 0);
        ShoppingCart instance = new ShoppingCart();
        assertTrue(instance.findProduct(p.getTitle()));
        instance.removeItem(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
    @Test
    public void testRemoveItemCarroVacio() throws Exception{
        /*System.out.println("removeItem");
        Product p =  new Product("Nuevo", 0);
        ShoppingCart instance = new ShoppingCart();
        assertTrue(!instance.isEmpty());
        assertTrue(instance.findProduct(p.getTitle()));
        instance.removeItem(p);*/
         
    }
}
