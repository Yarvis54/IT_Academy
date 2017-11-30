package com.jcourse.Evdokimov;

import java.nio.charset.Charset;

/**
 * Created by Pavel on 25.11.2017.
 */
public class SysProp {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        String s = new String("my String".getBytes(), Charset.forName("CP866"));

        String s1 = new String("dsf".getBytes(Charset.forName("CP866")));
        //System.out.println(s.);

        System.out.println(s1);
        //попробовать вывести кодировки созданных строк
    }
}

