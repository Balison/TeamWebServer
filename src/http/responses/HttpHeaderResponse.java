package http.responses;

import java.io.File;
import java.time.Instant;
import java.util.Date;
import webserver.FileManager;

/**
 *
 * @author Usuario
 */
public class HttpHeaderResponse {
    
    private final String date;
    private final String contentType;
    //elementos header
    
    public HttpHeaderResponse(File file) {
        FileManager manager = new FileManager();
        contentType = manager.getType(file);
        date = Date.from(Instant.now()).toString();
    }
    
    public boolean equals(Object other){
        if(other instanceof HttpHeaderResponse){
            HttpHeaderResponse otherHeader = (HttpHeaderResponse) other;
            return date.equals(otherHeader.date) && 
                    contentType.equals(otherHeader.contentType);
        }
        return false;
    }
    
}
