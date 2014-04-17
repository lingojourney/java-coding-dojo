package lingojourney;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;

public class MeaningOfLifeTest extends TestCase
{

    public void test_get_instance_return_same_instance()
    {
        assertEquals(MeaningOfLife.getInstance(), MeaningOfLife.getInstance());
    }

    public void test_get_meaning_of_life() {
        assertEquals(42, MeaningOfLife.getInstance().getMeaning());
    }

    public void test_no_private_constructor(){
        Constructor<?>[] constructors = MeaningOfLife.class.getConstructors();
        assertEquals(0, constructors.length);
    }
}
