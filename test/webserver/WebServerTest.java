package webserver;

import http.responses.HttpResponse;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author TeamServer
 */
public class WebServerTest {
    
    @Test
    public void testFullRequestGET_OK() throws IOException {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "GET");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_OK() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "HEAD");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/as.html", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/as.html", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHED_NOT_IMPLEMENT() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HED", "/as.html", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 501);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_EMPTY_URL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_EMPTY_URL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "", "HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_BAD_PROTOCOL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/index.html", "HTTP/1.1");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_BAD_PROTOCOL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/index.html", "HTTP/1.1");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
        @Test
    public void testSimpleRequestGET_OK() throws IOException {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_OK() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/as.html");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestGET_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/as.html");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHED_NOT_IMPLEMENT() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HED", "/as.html");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_EMPTY_URL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
}
