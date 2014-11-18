/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webserver;

import java.io.File;

/**
 *
 * @author Diego Gabriel
 */
public class FileManager {
    
    private final String defaultFileName;
    
    public FileManager(String def){
        defaultFileName = def;
    }
    
    public File findFile(String url){
        File file;
        
        if (urlHasNoFile(url))
            url = url + defaultFileName;
        
        if (url.charAt(0) == '/')
            url = url.substring(1);
        
        file = new File(url);
        
        return file;
    }
    
    private boolean urlHasNoFile(String url){
        return url.charAt(url.length()-1) == '/';
    }

    public String getType() {
        if(defaultFileName.contains(".html")){
            return "text/html";
        }
        if(defaultFileName.endsWith(".css")){
            return "text/css";
        }
        if(defaultFileName.endsWith(".txt")){
            return "text/plain";
        }
        if(defaultFileName.endsWith(".gif")){
            return "image/gif";
        }
        if(defaultFileName.endsWith(".png")){
            return "image/png";
        }
        return "text/plain";
    }
}
