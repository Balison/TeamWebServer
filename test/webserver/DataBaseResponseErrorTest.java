/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franko
 */
public class DataBaseResponseErrorTest {
   
    
    @Test
    public void response400(){
        String espected="Bad Request";
        String actual=DataBaseResponseError.response(400);
        assertEquals(espected, actual);
    }
    @Test
    public void detailedResponse400(){
        String espected="Your browser sent a request that this server could not understand.";
        String actual=DataBaseResponseError.detailedResponse(400,null,null);
        assertEquals(espected, actual);
    }
    @Test
    public void response404(){
        String espected="Not Found";
        String actual=DataBaseResponseError.response(404);
        assertEquals(espected, actual);
    }
    @Test
    public void detailedResponse404(){
        String espected="The requested URL /index.php was not found on this server.";
        String resource="/index.php";
        String actual=DataBaseResponseError.detailedResponse(404,null,resource);
        assertEquals(espected, actual);
    }
    @Test
    public void response501(){
        String espected="Method Not Implemented";
        String actual=DataBaseResponseError.response(501);
        assertEquals(espected, actual);
    }
    @Test
    public void detailedResponse501(){
        String espected="DELETE to /index.html not supported.";
        String resource="/index.html";
        String method="DELETE";
        String actual=DataBaseResponseError.detailedResponse(501,method,resource);
        assertEquals(espected, actual);
    }
}
