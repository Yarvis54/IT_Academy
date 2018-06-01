package com.jcourse.Evdokimov.s5_1;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

public class Indexer {
    /*String t = new String("sdfswef");
    String q = "dfs" + URLEncoder.encode()
    URLEncoder r;*/

    public static String getHtmlFromPath(String path) {
        File baseFolder = new File(path);
        List<String> foldersInCurrent = new ArrayList<String>();
        List<FileInfo> filesInCurrent = new ArrayList<FileInfo>();
        if (baseFolder.exists() && baseFolder.isDirectory()) {
            File[] files = baseFolder.listFiles();
            for (File currentFile : files) {
                if (currentFile.isDirectory())       //если дирректория
                {
                    foldersInCurrent.add(currentFile.getName());
                } else                                //если файл
                {
                    filesInCurrent.add(new FileInfo(currentFile.getName(), currentFile.length(), new Date(currentFile.lastModified())));
                }
            }
        }
        foldersInCurrent.sort(String::compareTo);
        StringBuilder tempHTML = new StringBuilder();
        tempHTML.append("<html><head><title>").append(path).append("</title></head><body><table border=\"1\" bordercolor=\"0xff0000\"><tr><td>Name</td><td>Size</td><td>Modify</td></tr>");
        if(foldersInCurrent != null){
            for(String r : foldersInCurrent){
                tempHTML.append("<tr><td><a href=\"").append(r).append("\">").append(r).append("</a></td><td></td><td></td></tr>");
            }
        }
        if(filesInCurrent != null){
            for(FileInfo r : filesInCurrent){
                tempHTML.append("<tr><td>").append(r.getName()).append("</td><td>").append(r.getSize().toString());
                tempHTML.append("</td><td>").append(r.getModify().toString()).append("</td></tr>");
            }
        }
        tempHTML.append("</table></body></html>");
        return tempHTML.toString();
    }
}

class FileInfo{
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
    protected String getName() {return this.name;}
    protected Long getSize() {return this.size;}
    protected Date getModify() {return this.lastModify;}
}
