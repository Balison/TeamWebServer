/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpForm;

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
public class TextoTest {
    
    @Test
    public void getValueForNameNull(){
        Texto input=new Texto("nombre","Ponga Nombre","Marco");
        assertNull(input.getValue("apellido"));
    }
    @Test
    public void getValueForNameNotNull(){
        Texto input=new Texto("nombre","Ponga Nombre","Marco");
        assertNotNull(input.getValue("nombre"));
    }
    @Test
    public void getValueForName(){
        Texto input=new Texto("nombre","Ponga Nombre","Marco");
        String expected="Marco";
        assertEquals(expected,input.getValue("nombre"));
    }
}
