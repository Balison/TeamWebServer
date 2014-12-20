
package webserver;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author TeamServer
 */
public class ParametersManagerTest {

    @Test
    public void testLoad1Parametro() {
        ParametersManager manager = new ParametersManager();
        Map<String, String> respuestaCalculada = manager.load("nombre=alison");
        Map<String, String> respuestaEsperada = new HashMap<>();
        respuestaEsperada.put("nombre", "alison");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testLoadParametros() {
        ParametersManager manager = new ParametersManager();
        Map<String, String> respuestaCalculada = manager.load("nombre=alison&pass=alison");
        Map<String, String> respuestaEsperada = new HashMap<>();
        respuestaEsperada.put("nombre", "alison");
        respuestaEsperada.put("pass", "alison");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
}
