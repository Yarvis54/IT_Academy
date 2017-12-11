package com.jcourse.Evdokimov.s1;

import static java.nio.charset.Charset.*;
import java.util.Scanner;

import java.io.InputStreamReader;

/**
 * Created by Pavel on 25.11.2017.
 */
public class Echo {
    public static void main(String[] args) {
        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //or
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //System.out.println(s);
        //String s1 = new String("Hello World", defaultCharset().toString());
        while(!s.equals("quit"))
        {
            System.out.println(s);
            s = scanner.nextLine();
        }

    }
}
