package webserver;

import http.responses.HttpResponse;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Diego Gabriel
 */
public class WebServerTest {
    
    @Test
    public void testRequestGET_OK() {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("/index.html"), 200);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testRequestHEAD_OK(){
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("/index.html"), 200);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testRequestHEAD_NOT_FOUND(){
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/as.html", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("error404.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testRequestGET_NOT_FOUND(){
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/as.html", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("error404.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
}
