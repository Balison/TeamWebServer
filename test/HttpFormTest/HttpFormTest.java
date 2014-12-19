/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpForm;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franko
 */
public class HttpFormTest {
    @Test
    public void transformMethodUperCase(){
        String action="inscribirse.html";
        String method="post";
        HttpForm formulario =new HttpForm(action,method);
        String expected="POST";
        assertEquals(expected,formulario.getMethod());
    }
    @Test
    public void transformMethodUperCase2(){
        String action="inscribirse.html";
        String method="post";
        HttpForm formulario =new HttpForm(action,method);
        String expected="POST";
        assertTrue(expected.equals(formulario.getMethod()));
    }
    
}
