package com.jcourse.Evdokimov.s5;

import java.util.Arrays;

public class TestException {
    public static void main(String[] args) {
        MyExceptionGenerator myException = new MyExceptionGenerator();
        try{
            //MyExceptionGenerator myException = new MyExceptionGenerator();
            myException.generateStackOverflowError();
        }catch(Error e){
            System.out.println(e.toString());
            System.out.println(e.getStackTrace());
        }
        //System.out.println("test");
        try{
            myException = new MyExceptionGenerator();
            myException.generateNullPointerException();
        }catch(Exception e1){
            System.out.println(e1.toString());
            e1.printStackTrace();
        }
        try{
            myException = new MyExceptionGenerator();
            myException.generateClassCastException();
        }catch(Exception e2){
            System.out.println(e2.toString());
            e2.printStackTrace();
        }
        try{
            myException = new MyExceptionGenerator();
            myException.generateNumberFormatException();
        }catch(NumberFormatException e3){
            System.out.println(e3.toString());
            e3.printStackTrace();
        }
        try{
            myException = new MyExceptionGenerator();
            myException.generateOutOfMemoryError();
        }catch(OutOfMemoryError e4){
            System.out.println(e4.toString());
            e4.printStackTrace();
        }
        try{
            myException = new MyExceptionGenerator();
            myException.generateMyException("Test exception");
        }catch(Exception e5){
            System.out.println(e5.toString());
            e5.printStackTrace();
        }
    }
}
