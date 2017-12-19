package com.jcourse.Evdokimov.s5;

import java.util.List;


public class MyExceptionGenerator implements ExceptionGenerator {
    @Override
    public void generateNullPointerException() {
        List<Integer> i = null;
        i.get(3);
    }

    @Override
    public void generateClassCastException() {
        Integer i = 2;
        Double d = 5.0;
        i = (Integer) (Object) d;
    }

    @Override
    public void generateNumberFormatException() {
        String s = "fgjhdfbvhjzbvahbdh";
        Integer i = Integer.parseInt(s);
    }

    @Override
    public void generateStackOverflowError() {
        generateStackOverflowError();
    }

    @Override
    public void generateOutOfMemoryError() {
        double d[] = new double [Integer.MAX_VALUE];
    }

    @Override
    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }
}
