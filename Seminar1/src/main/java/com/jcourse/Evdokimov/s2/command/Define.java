package com.jcourse.Evdokimov.s2.command;

import com.jcourse.Evdokimov.s2.Calc;
import com.jcourse.Evdokimov.s2.CalcException;
import com.jcourse.Evdokimov.s2.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Pavel on 30.11.2017.
 */
public class Define implements Command {
    public void execute(Stack<Double> intStack, Map<String, Double> intMap, String... arguments) throws CalcException{
        Double val;
        if(arguments.length>1)
            try {
                val = Double.valueOf(arguments[1]);
                intMap.put(arguments[0], val);
            }catch (Exception e){
                throw new CalcException(e);
            }

    }
}
