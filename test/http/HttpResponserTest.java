/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import http.responses.*;
import java.io.File;
import static org.junit.Assert.*;


/**
 *
 * @author Diego Gabriel
 */
public class HttpResponserTest {
    
    public HttpResponserTest() {
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

    @Test
    public void testRespondTo_OK() {
        HttpResponse returnedResult = HttpResponser.respondTo("http/1.0", new File("index.html"), 200);
        HttpResponse expectedResult = new HttpResponse("http/1.0", new File("index.html"), 200);
        assertEquals(expectedResult, returnedResult);
    }
    
    
}
