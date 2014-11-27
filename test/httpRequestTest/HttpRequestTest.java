
package httpRequestTest;

import httpRequest.HttpRequest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franko
 */
public class HttpRequestTest {

    
    @Test
    public void equalsHttpRequest(){
        HttpRequest request=new HttpRequest("GET", "/index.html", "HTTP/1.0");
        HttpRequest request1=new HttpRequest("GET", "/index.html", "HTTP/1.0");
        assertTrue(request.equals(request1));
    }
    @Test
    public void notEqualsHttpRequestMethod(){
        HttpRequest request=new HttpRequest("GET", "/index.html", "HTTP/1.0");
        HttpRequest request1=new HttpRequest("POST", "/index.html", "HTTP/1.0");
        assertFalse(request.equals(request1));
    } 
    @Test
    public void notEqualsHttpRequestResuorce(){
        HttpRequest request=new HttpRequest("GET", "/index.html", "HTTP/1.0");
        HttpRequest request1=new HttpRequest("GET", "/index.php", "HTTP/1.0");
        assertFalse(request.equals(request1));
    } 
    @Test
    public void notEqualsHttpRequestVersion(){
        HttpRequest request=new HttpRequest("GET", "/index.html", "HTTP/1.0");
        HttpRequest request1=new HttpRequest("GET", "/index.html", "HTTP/1.5");
        assertFalse(request.equals(request1));
    }            
}
