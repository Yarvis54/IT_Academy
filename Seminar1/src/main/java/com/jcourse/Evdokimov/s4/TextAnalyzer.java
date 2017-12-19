package com.jcourse.Evdokimov.s4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzer {
    public static void main(String[] args) throws IOException {
        //InputStreamReader readStream;
        Map<String,Integer> wordsMap = new HashMap<>();
        int charArray[] = new int[1024];
        int currentPos = 0;

        if(args.length!=2) {
            System.out.println("Expect two args");
        }
        try(Reader readStream = new InputStreamReader(new BufferedInputStream(new FileInputStream(args[0])),"UTF-8")) {
           // readStream = new InputStreamReader(new BufferedInputStream(new FileInputStream("fefrw.csv")),"UTF-8");
            StringBuilder tempString = new StringBuilder();
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
        }

        //дописать ранее чтение строк (с учетом последнего слова в конце файла)
        //сделать сначала чтение количества слов и если нул, то реагируем на отсутствие слова

        List<Map.Entry<String,Integer>> allWords = new ArrayList<>(wordsMap.entrySet());
        allWords.sort((a,b) ->{
            int rs = Integer.compare(b.getValue(), a.getValue());
            if(rs==0) {
                String word1 = a.getKey();
                String word2 = b.getKey();
                rs = word1.compareTo(word2);
            }
            return rs;
        });
        for(Map.Entry<String,Integer> allWord : allWords){
            System.out.printf("%s\t%s%n",allWord.getKey(),allWord.getValue());  //%n - перевод строки в зависимости от платформы
        }
    }
}


//посмотреть java stream api и возможно реализовать через него (BufferedReaded.lines())

//WireShark - сниффер для отладки 5 лабы (сервера)