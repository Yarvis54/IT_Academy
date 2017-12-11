package com.jcourse.Evdokimov.s2.command;

import com.jcourse.Evdokimov.s2.commandOld;

/**
 * Created by Pavel on 30.11.2017.
 */
public class Sub extends commandOld {
    @Override
    public void execute(String... s) {
        _stack.push(_stack.pop()-_stack.pop());
    }
}
