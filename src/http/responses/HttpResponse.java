

package http.responses;

import java.io.File;

/**
 *
 * @author Diego Gabriel
 */
public class HttpResponse {
    
    private HttpHeaderResponse header;
    
    private final int statusCode;
    private final String vProtocol;
    
    public HttpResponse(String vProtocol, File file, int status){
        statusCode = status;
        this.vProtocol = vProtocol;
        header = new HttpOKHeaderResponse();
    }
    
    public HttpResponse(String vProtocol, int status){
        statusCode = status;
        this.vProtocol = vProtocol;
        header = new HttpDefaultHeaderResponse();
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof HttpResponse){
            HttpResponse otherResponse = (HttpResponse) other;
            return statusCode == otherResponse.statusCode &&
                    vProtocol.equals(otherResponse.vProtocol) &&
                    header.equals(otherResponse.header);
        }
        return false;
    }    
}
