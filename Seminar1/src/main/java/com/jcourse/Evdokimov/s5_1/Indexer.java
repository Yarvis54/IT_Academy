package com.jcourse.Evdokimov.s5_1;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Indexer {
    /*String t = new String("sdfswef");
    String q = "dfs" + URLEncoder.encode()
    URLEncoder r;*/

    public static String getHtmlFromPath(String path) {
        File baseFolder = new File(path);
        List<String> foldersInCurrent = new ArrayList<String>();
        List<FileInfo> filesInCurrent = new ArrayList<FileInfo>();
        if(baseFolder.exists() && baseFolder.isDirectory())
        {
            File[] files = baseFolder.listFiles();
            for(File currentFile : files)
            {
                if(currentFile.isDirectory())       //если дирректория
                {
                    foldersInCurrent.add(currentFile.getName());
                }
                else                                //если файл
                {
                    filesInCurrent.add(new FileInfo(currentFile.getName(),currentFile.length(),new Date(currentFile.lastModified())));
                }

            }
        }
        String::co
        foldersInCurrent.sort(String::compareTo);
        StringBuilder tempHTML = new StringBuilder();
        tempHTML.append("<html><head><title>").append(path).append("</title></head><body><table><tr><td>");
    }
}

private class FileInfo{
    private String name;
    private long size;
    private Date lastModify;
    protected FileInfo(String name, long size, Date lastModify)
    {
        this.name = name;
        this.size = size;
        this.lastModify = lastModify;
    }
    protected int compareTo(FileInfo s)
    {
        return this.name.compareTo(s.name);
    }
}
