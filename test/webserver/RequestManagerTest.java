
package webserver;

import http.responses.HttpResponse;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TeamServer
 */
public class RequestManagerTest {
    
    @Test
    public void requestGetLine() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("GET /");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    @Test 
    public void requestHead() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HEAD / HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "HEAD");
        assertEquals(expectedResponse, requestResponse);
    }
    
}
