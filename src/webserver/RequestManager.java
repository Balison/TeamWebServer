
package webserver;

import http.HttpResponser;
import http.responses.HttpResponse;
import java.io.IOException;

/**
 *
 * @author TeamServer
 */
public class RequestManager {
    
    private final FileManager fileManager;
    private final ValidatorRequest validatorRequest;
    
    public RequestManager(){
        fileManager = new FileManager();
        validatorRequest = new ValidatorRequest(fileManager);
    }

    public HttpResponse management(String request) throws IOException {
        request = request.trim();
        request = request.split("\n")[0];
        String[] requestLine = request.split(" ");
        String method, resource = " ", version;
        if(requestLine.length > 3){
            method = requestLine[0];
            resource = requestLine[1];
            version = requestLine[2];
            return request(method, resource, version);
        }
        else if(requestLine.length == 3){        
            method = requestLine[0];
            resource = requestLine[1];
            version = requestLine[2];
            return request(method, resource, version);
        }else if(requestLine.length == 2){
            method = requestLine[0];
            resource = requestLine[1];
            return request(method, resource);
        }else{
            method = requestLine[0];
            return request(method, resource);
        }
    }
    
    private HttpResponse request(String method, String url, String protocol) throws IOException {
        int status = validatorRequest.validateFullRequest(method, url, protocol);
        if (status == 200) {
            return HttpResponser.respondTo(fileManager.findFile(url), method);
        }
        return HttpResponser.respondTo(fileManager.updateFile(status,method,url), status);
    }
    
    private HttpResponse request(String method, String url) throws IOException {
        int status = validatorRequest.validateSimpleRequest(method, url);
        if (status == 200) {
            return HttpResponser.respondTo(fileManager.findFile(url));
        } else {
            return HttpResponser.respondTo(fileManager.updateFile(status,method,url));
        }
    }
}
