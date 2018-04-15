package csv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CSV1Test {
    private CSV1 csv1;

    @Before
    public void setUp() throws Exception {
        csv1 = new CSV1();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sayHello() throws Exception {
        assertEquals("hello", csv1.sayHello());
    }

}