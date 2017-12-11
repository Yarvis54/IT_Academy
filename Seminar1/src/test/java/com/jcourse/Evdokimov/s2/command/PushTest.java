package com.jcourse.Evdokimov.s2.command;

import com.jcourse.Evdokimov.s2.CalcException;
import com.jcourse.Evdokimov.s2.Command;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Pavel on 30.11.2017.
 */
public class PushTest extends TestCase {
    public void testCommand() throws  CalcException{
        Push t = new Push();
        Stack<Double> intStack = new Stack<Double>();
        String[] args = {"9"};
        t.execute(intStack, new HashMap<String, Double>(), args);
        assertEquals(9.0, intStack.peek(), 1e-9);
    }

}
