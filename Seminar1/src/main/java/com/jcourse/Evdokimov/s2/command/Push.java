package com.jcourse.Evdokimov.s2.command;

import com.jcourse.Evdokimov.s2.CalcException;
import com.jcourse.Evdokimov.s2.Command;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Pavel on 30.11.2017.
 */
public class Push implements Command {
    public void execute(Stack<Double> intStack, Map<String, Double> intMap, String s[]) throws CalcException {
        Double val;
        if(s.length == 1)
        {

            if(intMap.containsKey(s[0]))
                intStack.push(intMap.get(s[0]));
            else {
                try {
                    val = Double.valueOf(s[0]);
                    intStack.push(val);
                } catch (Exception e) {
                    throw new CalcException("Wrong params", e);
                }
            }
        }

     //   intStack.push(Double.valueOf(s[0]));
     //   else {
     //       if(intMap.containsKey(s[0])) _stack.push(_map.get(s[0]));
     //       else System.out.println("Key: " + s[0] + " is not defined!");
     //   }
    }
}
