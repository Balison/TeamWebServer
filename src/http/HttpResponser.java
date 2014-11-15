package http;

import java.io.File;
import http.responses.*;

/**
 *
 * @author Diego Gabriel
 */
public class HttpResponser {
    public static HttpResponse respondTo(String method, String vProtocol, 
                                  File file, int status){
        HttpResponse response = null;
        
        if (method.equals("GET"))
            response = new HttpGetResponse(vProtocol, file, status);
        
        
        return response;
    }
    
    public static HttpResponse respondTo(String method, String vProtocol, 
                                  int status){
        
        HttpResponse response = null;
        
        if (method.equals("HEAD"))
                response = new HttpGetResponse(vProtocol, null, status);
        
        return response;
        
    }
}
