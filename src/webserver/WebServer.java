package webserver;

import http.HttpResponser;
import http.responses.HttpResponse;
import java.io.File;

/**
 *
 * @author Diego Gabriel
 */
public class WebServer {

    private final String defaultFileName;
    private final FileManager fileManager;
    
    public static final String SERVER_NAME = "apachito/0.1";
    
    public WebServer(){
        defaultFileName = "index.html";
        fileManager = new FileManager(defaultFileName);
    }
    
    public HttpResponse request(String method, String url, String protocol){
        HttpResponse response;
        File file = fileManager.findFile(url);
        
        if (!file.exists()){
            response = HttpResponser.respondTo(protocol, 
                       404);
        }
        else{
            response = HttpResponser.respondTo(protocol, file, 
                       200);
        }
        
        return response;
    }
    
}
