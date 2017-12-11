package com.jcourse.Evdokimov.s2;

import java.util.Map;
import java.util.Stack;

public interface Command {
    public void execute (Stack<Double> stack, Map<String,Double> map,String... arguments)  throws CalcException;
}
