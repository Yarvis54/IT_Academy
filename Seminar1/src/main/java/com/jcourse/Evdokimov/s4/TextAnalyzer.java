package com.jcourse.Evdokimov.s4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {
    public static void main(String[] args) {
        InputStreamReader readStream;
        Map<String,Integer> wordsMap = new HashMap<>();
        int charArray[] = new int[1024];
        int currentPos = 0;
        StringBuilder tempString = new StringBuilder();
        try {
            readStream = new InputStreamReader(new BufferedInputStream(new FileInputStream("fefrw.csv")),"UTF-8");
            for(int i=readStream.read();i>0;i=readStream.read())
            {
                if(Character.isLetterOrDigit(i))
                    tempString.append((char)i);
                else
                    if(tempString.length()!=0)
                    {
                        String toVerify = new String(tempString.toString());
                        if(wordsMap.containsKey(toVerify))
                        {
                            wordsMap.put(toVerify,wordsMap.get(toVerify)+1);
                        }else{
                            wordsMap.put(toVerify,1);
                        }
                        tempString.setLength(0);
                    }
            }
        }catch(Exception e){

        }
    }
}
