package com.jcourse.Evdokimov.s2;

import java.util.Scanner;

/**
 * Created by Pavel on 02.12.2017.
 */
public class DataLoader {
    private Scanner scanner;
    private String currentString;

    public DataLoader(){scanner = new Scanner(System.in);}

    //public String GetLine(){return currentString;}

    public String GetNextLine(){
        currentString = scanner.nextLine();
        return currentString;
    }
}
k