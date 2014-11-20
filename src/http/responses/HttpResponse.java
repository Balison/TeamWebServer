

package http.responses;

import java.io.File;

/**
 *
 * @author Diego Gabriel
 */
public class HttpResponse {
    
    private HttpHeaderResponse header;
    private HttpBodyResponse body;
    
    private final int statusCode;
    
    public HttpResponse(File file, int status){
        statusCode = status;
        header = new HttpHeaderResponse(file);
        //armar cuerpo si es GET
    }
    
    public HttpResponse(File file){
        statusCode = -1;
        header = null;
        //armar cuerpo
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof HttpResponse){
            HttpResponse otherResponse = (HttpResponse) other;
            return statusCode == otherResponse.statusCode &&
                    header.equals(otherResponse.header);
        }
        return false;
    }    
}
