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
public class EnteroTest {
    
   
    @Test
    public void getValueForNameNull(){
        Entero input=new Entero("edad","Ponga Edad","12");
        assertNull(input.getValue("apellido"));
    }
    @Test
    public void getValueForNameNotNull(){
        Entero input=new Entero("edad","Ponga Edad","12");
        assertNotNull(input.getValue("edad"));
    }
    @Test
    public void getValueForName(){
        Entero input=new Entero("edad","Ponga Edad","12");
        Integer expected=12;
        assertEquals(expected,input.getValue("edad"));
    }
}
