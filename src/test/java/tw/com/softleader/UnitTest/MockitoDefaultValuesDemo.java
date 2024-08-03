package tw.com.softleader.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import tw.com.softleader.UnitTest.test1.Demo;

public class MockitoDefaultValuesDemo {

    @Test
    void testDefaultValues(){
        Demo demo = mock(Demo.class);
        assertEquals(0, demo.getInt());
        assertEquals(0, demo.getInteger());
        assertEquals(0, demo.getInteger().intValue());
        assertEquals(0d, demo.getDouble(), 0d);
        assertFalse(demo.getBoolean());
        assertNull(demo.getObject());
        assertEquals(Collections.emptyList(), demo.getCollection());
        assertNull(demo.getArray());
        assertEquals(0L, demo.getStream().count());
        assertFalse(demo.getOptional().isPresent());
    }

    @Test
    void testdeltaparam(){
        assertEquals(0.0012f, 0.0014f, 0.0002); // true
//        assertEquals(0.0012f, 0.0014f, 0.0001); //false
    }
}
