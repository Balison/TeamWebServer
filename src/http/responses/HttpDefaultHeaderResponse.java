/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http.responses;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class HttpDefaultHeaderResponse implements HttpHeaderResponse {
    
    private final String date;
    private final String contentType;

    public HttpDefaultHeaderResponse() {
        contentType = "text/html";
        date = Date.from(Instant.now()).toString();
    }
    
    public boolean equals(Object other){
        if(other instanceof HttpDefaultHeaderResponse){
            HttpDefaultHeaderResponse otherHeader = (HttpDefaultHeaderResponse) other;
            return date.equals(otherHeader.date) && 
                    contentType.equals(otherHeader.contentType);
        }
        return false;
    }
    
}
