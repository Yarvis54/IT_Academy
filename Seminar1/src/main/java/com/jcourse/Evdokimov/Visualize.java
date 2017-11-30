package com.jcourse.Evdokimov;

import java.util.Scanner;

/**
 * Created by Pavel on 30.11.2017.
 */
public class Visualize {
    private Scanner scanner;
    public Visualize()
    {
        scanner = new Scanner(System.in);
    }

    public void showMess(String stringToShow)
    {
        System.out.println(stringToShow);
    }

    public int readInt()
    {
        String s = scanner.nextLine();
        int readInt = Integer.parseInt(s);
        return readInt;
    }
}
