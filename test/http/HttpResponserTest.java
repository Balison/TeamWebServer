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

    @Test
    public void testRespondTo_OK() {
        HttpResponse returnedResult = HttpResponser.respondTo(new File("index.html"), 200);
        HttpResponse expectedResult = new HttpResponse(new File("index.html"), 200);
        assertEquals(expectedResult, returnedResult);
    }
    
    
}
