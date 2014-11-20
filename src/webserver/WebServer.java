package webserver;

import http.HttpResponser;
import http.responses.HttpResponse;

/**
 *
 * @author Diego Gabriel
 */
public class WebServer {

    private final FileManager fileManager;
    private final String metodos[] = {"HEAD", "GET", "POST"};
    
    public static final String SERVER_NAME = "apachito/0.1";
    
    public WebServer(){
        fileManager = new FileManager();
    }
    
    public HttpResponse request(String method, String url, String protocol){
            
        int status = getStatus(method, url, protocol);
        
        if(status == 000){
            return HttpResponser.respondTo(fileManager.findFile(url));
        }
        
        if(status == 200){
            return HttpResponser.respondTo(fileManager.findFile(url), status);
        }
        
        return HttpResponser.respondTo(fileManager.updateFile(status), status);
    }

    private int getStatus(String method, String url, String protocol) {
        if(!metodoImplementado(method))
            return 501;
        if(url.isEmpty())
            return 400;
        if(protocol == null)
            return 000;//esto es cuando requestSimple
        if(!protocol.equals("HTTP/1.0"))
            return 400;
        if(fileManager.findFile(url).exists())
            return 200;
        else
            return 404;
    }
    
    
    private boolean metodoImplementado(String metodo) {
        int metodoDefinido = 0;
        while(metodoDefinido < metodos.length){
            if(metodos[metodoDefinido].equals(metodo))
                return true;
            metodoDefinido++;
        }
        return false;
    }
    
}
