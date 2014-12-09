package webserver;

import http.HttpResponser;
import http.responses.HttpResponse;
import java.io.IOException;

/**
 *
 * @author TeamServer
 */
public class WebServer {

    private final FileManager fileManager;
    private final String metodos[] = {"HEAD", "GET", "POST"};

    public static final String SERVER_NAME = "apachito/0.1";

    public WebServer() {
        fileManager = new FileManager();
    }

    public HttpResponse request(String method, String url, String protocol) throws IOException {
        int status = validateFullRequest(method, url, protocol);
        if (status == 200) {
            return HttpResponser.respondTo(fileManager.findFile(url), method);
        }
        return HttpResponser.respondTo(fileManager.updateFile(status,method,url), status);
    }
    
    
    public HttpResponse request(String method, String url) throws IOException {
        int status = validateSimpleRequest(method, url);
        if (status == 200) {
            return HttpResponser.respondTo(fileManager.findFile(url));
        } else {
            return HttpResponser.respondTo(fileManager.updateFile(status,method,url));
        }
    }

    private boolean metodoImplement(String metodo) {
        int metodoDefinido = 0;
        while (metodoDefinido < metodos.length) {
            if (metodos[metodoDefinido].equals(metodo)) {
                return true;
            }
            metodoDefinido++;
        }
        return false;
    }

    private int validateSimpleRequest(String method, String url) {
        if (method.equals("GET")) {
            if (fileManager.findFile(url).exists()) {
                return 200;
            } else {
                return 404;
            }
        }
        if (method.equals("HEAD")) {
            return 400;
        } else {
            return 501;
        }
    }

    private int validateFullRequest(String method, String url, String protocol) {
        if (!metodoImplement(method)) {
            return 501;
        }
        if (url.isEmpty()) {
            return 400;
        }
        if (!protocol.equals("HTTP/1.0")) {
            return 400;
        }
        if (fileManager.findFile(url).exists()) {
            return 200;
        } else {
            return 404;
        }
    }
    public HttpResponse loadRequest(String request) throws IOException{
        HttpResponse respons=null;
        request = request.trim();
        String[] requestLine = request.split(" ");
        String method="";
        String resource="";
        String version="";
        if(requestLine.length==3){        
            method = requestLine[0];
            resource =  requestLine[1];
            version =  requestLine[2];
            respons= request(method,resource,version);
        }else if(requestLine.length==2){
            method = requestLine[0];
            resource =  requestLine[1];
           
            respons= request(method,resource);
        }else if(requestLine.length==1){
            method = requestLine[0];
            respons= request(method,resource);
        }
    return respons;
    }
}
