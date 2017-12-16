package com.jcourse.Evdokimov.s2;

import com.jcourse.Evdokimov.s2.command.*;

import java.io.File;
import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * Created by Pavel on 02.12.2017.
 */
public class Calc {
    public static void main(String[] args) {
        File fp;
        Command command;
        Map<String, Command> commandMap = new HashMap<String, Command>();
        commandMap.put("add", new Add());
        commandMap.put("define",new Define());
        commandMap.put("div",new Div());
        commandMap.put("mul",new Mul());
        commandMap.put("pop",new Pop());
        commandMap.put("print",new Print());
        commandMap.put("push",new Push());
        commandMap.put("sqrt",new Sqrt());
        commandMap.put("sub",new Sub());
        String fileline, workstring[], commandName;
        Map<String, Double> varMap = new HashMap<String, Double>();
        Stack<Double> workStack = new Stack<Double>();
        if(args.length>0)
        {
            try {
                fp = new File(args[0]);
                Scanner scanner = new Scanner(fp);
                while(scanner.hasNextLine()){
                    fileline = scanner.nextLine();
                    workstring = fileline.split("\\s");
                    commandName = new String(workstring[0].toLowerCase());
                    if(commandMap.containsKey(commandName))
                    {
                        commandMap.get(commandName).execute(workStack, varMap, workstring);
                    }else{
                        throw new NoSuchElementException("Command not found");
                    }
                }
            }catch(Exception e){

            }
        }
        DataLoader dataLine = new DataLoader();
        System.out.println(dataLine.GetNextLine());
    }
}
