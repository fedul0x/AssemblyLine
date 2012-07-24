/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.fedul0x.assemblyline.conveyor;

import org.junit.*;
import static org.junit.Assert.*;
import ru.fedul0x.assemblyline.filter.Filter;

/**
 *
 * @author Ivashin Alexey
 */
public class ConveyorTest {
    
    public ConveyorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addFilter method, of class Conveyor.
     */
    @Test
    public void testAddFilter_Filter() throws Exception {
        System.out.println("addFilter");
        Filter filter = null;
        Conveyor instance = new Conveyor();
        Conveyor expResult = null;
        Conveyor result = instance.addFilter(filter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFilter method, of class Conveyor.
     */
    @Test
    public void testAddFilter_Filter_int() throws Exception {
        System.out.println("addFilter");
        Filter filter = null;
        int position = 0;
        Conveyor instance = new Conveyor();
        Conveyor expResult = null;
        Conveyor result = instance.addFilter(filter, position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
