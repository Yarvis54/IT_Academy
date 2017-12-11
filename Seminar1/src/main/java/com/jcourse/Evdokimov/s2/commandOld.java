package com.jcourse.Evdokimov.s2;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Pavel on 30.11.2017.
 */
public abstract class commandOld {
    Stack<Double> _stack;
    Map<String,Double> _map;
    public abstract void execute (String... arguments);
}
