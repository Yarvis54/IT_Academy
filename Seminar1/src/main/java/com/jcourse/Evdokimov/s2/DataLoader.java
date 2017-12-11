package com.jcourse.Evdokimov.s2;

import java.util.Scanner;

/**
 * Created by Pavel on 02.12.2017.
 */
public class DataLoader {
    private Scanner _scanner;
    String _currentString;

    public DataLoader(){_scanner = new Scanner(System.in);}

    public String getLine(){return _currentString;}

    public String getNextLine(){
        _currentString = _scanner.nextLine();
        return _currentString;
    }
}
