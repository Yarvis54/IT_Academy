package com.jcourse.Evdokimov.s2.command;

import com.jcourse.Evdokimov.s2.CalcException;
import com.jcourse.Evdokimov.s2.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Pavel on 30.11.2017.
 */
public class Pop implements Command {
    public void execute(Stack<Double> intStack, Map<String, Double> intMap, String s[]) throws CalcException
    {
        try {
            intStack.pop();
        }catch(Exception e){
            throw new CalcException(e);
        }
    }
}
