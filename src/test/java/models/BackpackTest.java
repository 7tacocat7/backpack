package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class BackpackTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesInstanceOfBackpack_Backpack() throws Exception {
        Backpack backpack = new Backpack(true, "my things", 20);
        assertEquals(true, backpack instanceof Backpack);
    }
    @Test public void methodCallsUponConstructor() throws Exception{
        Backpack backpack = new Backpack(true, "my things",20);
        assertEquals(true,backpack.getMap());
    }
    @Test public void getStringMethodCallsUponConstructor() throws Exception{
        Backpack backpack = new Backpack (true,"things",20);
        assertEquals("things",backpack.getThings());
    }
    @Test
    public void minusMoneyFromWallet_15() throws Exception{
        Backpack backpack = new Backpack(true,"things",8);
        assertEquals(40, backpack.getWallet());
    }
//    public void AllPostsContainAllBackpacks_true(){
//        Backpack backpack = new Backpack(true, "socks,bannans,grapes",2);




}
