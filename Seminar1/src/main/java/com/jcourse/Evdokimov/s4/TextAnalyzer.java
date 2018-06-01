package com.jcourse.Evdokimov.s4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAnalyzer {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> wordsMap = new HashMap<>();
        double totalWord = 0;

        if(args.length!=2) {
            System.out.println("Expect two args");
            return;
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
                        totalWord++;
                        String toVerify = new String(tempString.toString());
                        Integer tempCount = wordsMap.get(toVerify);
                        if(tempCount == null)
                            wordsMap.put(toVerify,1);
                        else
                            wordsMap.put(toVerify,wordsMap.get(toVerify)+1);
                        /*
                        if(wordsMap.containsKey(toVerify))
                        {
                            wordsMap.put(toVerify,wordsMap.get(toVerify)+1);
                        }else{
                            wordsMap.put(toVerify,1);
                        }*/
                        tempString.setLength(0);
                    }
            }
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

        try(Writer writeStream = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(args[1])), "UTF-8")){
            for(Map.Entry<String,Integer> allWord : allWords){

                writeStream.write(String.format("%s,%d,%f%%%n",allWord.getKey(),allWord.getValue(),(double)allWord.getValue()/totalWord*100.00));
                //System.out.printf("%s\t%s%n",allWord.getKey(),allWord.getValue());  //%n - перевод строки в зависимости от платформы
            }
        }
    }
}


//посмотреть java stream api и возможно реализовать через него (BufferedReaded.lines())

//WireShark - сниффер для отладки 5 лабы (сервера)
//POSTMAN

/*
Class.forName("org.h2.Driver");
DriverManager.registerDriver();
DriverManager.getConnection();

CREATE TABLE POSTS(Id INT PRIMARY KEY,
    post_date DATE...
    post_message TEXT ...
    );
 */





/*работа через поток

try(BufferedReader reader = new BufferedReader(new InputStreamReader(
    new BufferedInputStream(new FileInputStream(args[0]))))){
        int[] count = {0};
        reader
            .lines()            //поток строк
            .map(line -> line.split("[^\\pL\\pN]")
            .flatMap(Arrays::stream)
            .filter(s -> !s.isEmpty())
            .map(word -> new SimpleEntry<>(word, 1))
            .peek(a->count[0]++)
            .collect(toMap(a->a, a->1,(a,b)->a+b))
                        //.collect(toMap(SimpleEntry::getKey, pair -> pair.getValue(), (a, b) -> a+b))        //прекращение потока
            .entrySet()                         //создание нового потока из мапы (collect)
            .stream()   //создание нового потока из пар
            .sorted((a, b) -> {
                int rs = b.getValue().compareTo(a.getValue());
                if (rs == 0) {
                    rs = a.getKey().compareTo(b.getKey());
                    }
                return rs;
                })
            .forEach(word,count) -> System.out.println(word+": "count));




    }
 */