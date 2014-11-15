

package http.responses;

import java.time.Instant;
import java.util.Date;
import webserver.WebServer;

/**
 *
 * @author Diego Gabriel
 */
public abstract class HttpResponse {
    public static final int OK = 200;
    public static final int NOT_FOUND = 404;
    
    private final int statusCode;
    private final String vProtocol;
    private final Date date;
    private final String contentType;
    
    public HttpResponse(int code, String vProtocol){
        statusCode = code;
        this.vProtocol = vProtocol;
        contentType = "text/html";
        date = Date.from(Instant.now());
    }
    public int getStatusCode() {
        return statusCode;
    }
    
    public String render(){
        String header;
        header = vProtocol + ' ' + statusCode + ' ' + getStatusMsg() + '\n';
        header = header + "Date: " + date.toString() + '\n';
        header = header + "Server: " + WebServer.SERVER_NAME + '\n';
        header = header + "Content-Type: " + contentType + '\n';
        
        return header + '\n';
    }
    
    public boolean equals(HttpResponse other){
        return other.render().equals(this.render());
    }
    
    
    private String getStatusMsg(){
        String msg = "";
        switch(statusCode){
            case HttpResponse.OK : {
                msg = "OK";
                break;
            }
            case HttpResponse.NOT_FOUND: {
                msg = "NOT FOUND";
                break;
            }
            
        }
                
        return msg;
    }
    
}
