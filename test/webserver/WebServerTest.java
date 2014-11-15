package webserver;

import http.responses.HttpResponse;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Diego Gabriel
 */
public class WebServerTest {
    
    public WebServerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of request method, of class WebServer.
     */
    @Test
    public void testRequestGET_OK() {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/", "http/1.0");
        HttpResponse expectedResponse = new HttpResponse("http/1.0", new File("/index.html"), 200);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testRequestHEAD_OK(){
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/", "http/1.0");
        HttpResponse expectedResponse = new HttpResponse("http/1.0", new File("/index.html"), 200);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testRequestHEAD_NOT_FOUND(){
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("HEAD", "/as.html", "http/1.0");
        HttpResponse expectedResponse = new HttpResponse("http/1.0", 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testRequestGET_NOT_FOUND(){
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.request("GET", "/as.html", "http/1.0");
        HttpResponse expectedResponse = new HttpResponse("http/1.0", 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
}
