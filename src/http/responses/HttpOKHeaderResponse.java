
package http.responses;

/**
 *
 * @author Usuario
 */
public class HttpOKHeaderResponse implements HttpHeaderResponse {
    
    private HttpDefaultHeaderResponse generalHeader;

    public HttpOKHeaderResponse() {
        generalHeader = new HttpDefaultHeaderResponse();
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
