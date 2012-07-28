package ru.fedul0x.wavepredict.assemblyline.conveyor;

import org.junit.*;
import static org.junit.Assert.*;
import ru.fedul0x.wavepredict.assemblyline.filter.Filter;
import ru.fedul0x.wavepredict.assemblyline.filter.OpenWaveFileFilter;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FileNameFilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FilterTarget;

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
        //result
        FileNameFilterTarget ft = new FileNameFilterTarget();
        ft.addArgument("/home/fedul0x/NetBeansProjects/Зайцева ИВ 8 кашель.wav");
        ft.addArgument("/home/fedul0x/NetBeansProjects/newmix.wav");
        Conveyor result = new Conveyor();
        OpenWaveFileFilter filter = new OpenWaveFileFilter(ft);
        result.addFilter(filter);
        //sample
        Conveyor instance = new Conveyor();
        OpenWaveFileFilter filter2 = new OpenWaveFileFilter(ft);
        instance.last = filter;
        instance.filters.add(filter2);

//        assertEquals(instance, result);
        assertTrue(instance.equals(result));
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

    /**
     * Test of removeFilter method, of class Conveyor.
     */
    @Test
    public void testRemoveFilter() {
        System.out.println("removeFilter");
        int position = 0;
        Conveyor instance = new Conveyor();
        instance.removeFilter(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Conveyor.
     */
    @Test
    public void testStart_0args() throws Exception {
        System.out.println("start");
        Conveyor instance = new Conveyor();
        FilterTarget expResult = null;
        FilterTarget result = instance.start();
//        assertEquals(expResult, result);
//        assertTrue(true);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Conveyor.
     */
    @Test
    public void testStart_FilterTarget() throws Exception {
        System.out.println("start");
        FilterTarget initData = null;
        Conveyor instance = new Conveyor();
        FilterTarget expResult = null;
        FilterTarget result = instance.start(initData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
