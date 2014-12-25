
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
    public void testSimpleRequestGET_OK() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("GET /");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HEAD /");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestPOST_OK() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("POST /");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_NOT_FOUND() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HEAD /as.html");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestGET_NOT_FOUND() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("GET /as.html");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHED_NOT_IMPLEMENT() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HED /as.html");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestPOST_NOT_FOUND() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("POST /as.html");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_EMPTY_URL() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HEAD");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_OK() throws IOException {
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("GET / HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "GET");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_OK() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HEAD / HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "HEAD");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestPOST_OK() throws IOException {
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("POST / HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "POST");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_NOT_FOUND() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HEAD /as.html HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_NOT_FOUND() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("GET /as.html HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestPOST_NOT_FOUND() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("POST /as.html HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHED_NOT_IMPLEMENT() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HED /as.html HTTP/1.0");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 501);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_BAD_PROTOCOL() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("HEAD /index.html HTTP/1.2");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_BAD_PROTOCOL() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("GET /index.html HTTP/1.2");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestPOST_BAD_PROTOCOL() throws IOException{
        RequestManager manager = new RequestManager();
        HttpResponse requestResponse = manager.management("POST /index.html HTTP/1.2");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
}
