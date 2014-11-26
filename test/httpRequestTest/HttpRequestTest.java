/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        HttpRequest request=new HttpRequest("GET /index.html HTTP/1.0");
        HttpRequest request1=new HttpRequest("GET /index.html HTTP/1.0");
        assertTrue(request.equals(request1));
    }
    @Test
    public void notEqualsHttpRequestMethod(){
        HttpRequest request=new HttpRequest("GET /index.html HTTP/1.0");
        HttpRequest request1=new HttpRequest("POST /index.html HTTP/1.0");
        assertFalse(request.equals(request1));
    } 
    @Test
    public void notEqualsHttpRequestResuorce(){
        HttpRequest request=new HttpRequest("GET /index.html HTTP/1.0");
        HttpRequest request1=new HttpRequest("GET /index.php HTTP/1.0");
        assertFalse(request.equals(request1));
    } 
    @Test
    public void notEqualsHttpRequestVersion(){
        HttpRequest request=new HttpRequest("GET /index.html HTTP/1.0");
        HttpRequest request1=new HttpRequest("GET /index.html HTTP/1.5");
        assertFalse(request.equals(request1));
    }         
    @Test
    public void haveMethodGet(){
        HttpRequest request=new HttpRequest("GET /index.html HTTP/1.0");        
        assertTrue(request.toHaveMethod());
    }
    @Test
    public void notHaveMethodGet(){
        HttpRequest request=new HttpRequest("get /index.html HTTP/1.0");        
        assertFalse(request.toHaveMethod());
    }
    @Test
    public void notHaveMethodGetTwo(){
        HttpRequest request=new HttpRequest("Get /index.html HTTP/1.0");        
        assertFalse(request.toHaveMethod());
    }
    @Test
    public void haveMethodPost(){
        HttpRequest request=new HttpRequest("POST /index.html HTTP/1.0");        
        assertTrue(request.toHaveMethod());
    }
    @Test
    public void haveMethodHead(){
        HttpRequest request=new HttpRequest("HEAD /index.html HTTP/1.0");        
        assertTrue(request.toHaveMethod());
    }
    @Test
    public void resourceCorrect(){
        HttpRequest request=new HttpRequest("POST /index.html HTTP/1.0");        
        assertTrue(request.isCorrectResource());
    }
    @Test
    public void resourceCorrectDefault(){
        HttpRequest request=new HttpRequest("POST / HTTP/1.0");        
        assertTrue(request.isCorrectResource());
    }
    @Test
    public void resourceNotCorrect(){
        HttpRequest request=new HttpRequest("POST index.html HTTP/1.0");        
        assertFalse(request.isCorrectResource());
    }
    @Test
    public void resourceNotCorrectOne(){
        HttpRequest request=new HttpRequest("POST HTTP/1.0");        
        assertFalse(request.isCorrectResource());
    }
    @Test
    public void resourceNotCorrectTwo(){
        HttpRequest request=new HttpRequest("POST **jghu HTTP/1.0");        
        assertFalse(request.isCorrectResource());
    }
    
    @Test
    public void versionCorrect() {
        HttpRequest request = new HttpRequest("POST /index.html HTTP/1.0");
        assertTrue(request.isSoportedVersion());
    }
    @Test
    public void versionNotCorrect() {
        HttpRequest request = new HttpRequest("POST /index.html HTTP/1.5");
        assertFalse(request.isSoportedVersion());
    }
    @Test
    public void versionIsEmpty() {
        HttpRequest request = new HttpRequest("POST /index.html");
        assertTrue(request.isSoportedVersion());
    }
    
}
