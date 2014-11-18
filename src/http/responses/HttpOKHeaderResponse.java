
package http.responses;

import java.io.File;
import webserver.FileManager;

/**
 *
 * @author Usuario
 */
public class HttpOKHeaderResponse implements HttpHeaderResponse {
    
    private HttpDefaultHeaderResponse generalHeader;

    public HttpOKHeaderResponse(File file) {
        generalHeader = new HttpDefaultHeaderResponse(file.getName());
    }
    @Override
    public boolean equals(Object other){
        if(other instanceof HttpOKHeaderResponse){
            HttpOKHeaderResponse otherHeader = (HttpOKHeaderResponse) other;
            return generalHeader.equals(otherHeader.generalHeader);
        }
        return false;
    }
}
