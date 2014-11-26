/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpRequest;

import java.io.File;

/**
 *
 * @author franko
 */
public class HttpRequest {

    private final static String methodes[] = {"GET", "POST", "HEAD"};

    private String method;
    private String resource;
    private String version;
    
    public HttpRequest(String request) {
        method="";
        resource="";
        version="";
        loadRequest(request);
    }
    private void loadRequest(String request) {
        
        request = request.trim();
        String[] requestLine = request.split(" ");
        if (requestLine.length == 3) {
            method = requestLine[0];
            resource = requestLine[1];
            version = requestLine[2];
        } else if (requestLine.length == 2) {
            method = requestLine[0];
            resource = requestLine[1];
        } else if (requestLine.length == 1) {
            method = requestLine[0];
        }

    }
    private boolean haveMethod(String method) {
        boolean toHave = false;
        int i = 0;
        while (!toHave && i < methodes.length) {
            if (methodes[i].equals(method)) {
                toHave = true;
            }
            i++;
        }
        return toHave;
    }
    
    public boolean toHaveMethod() {
        return haveMethod(method);
    }   
    public boolean isCorrectResource() {
        return resource.charAt(0) == '/';
    }    

    public boolean isSoportedVersion() {
        //if version is empty in request line, is default HTTP/1.0
        boolean soported = false;
        if (!version.isEmpty()) {
            soported = version.equals("HTTP/1.0");
        } else if (version.isEmpty()) {
            soported = true;
        }
        return soported;
    }
    public boolean equals(HttpRequest other){
        return method.equals(other.method)&& resource.equals(other.resource)&& version.equals(other.version);
    
    }

}
