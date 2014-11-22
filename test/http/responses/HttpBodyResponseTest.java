
package http.responses;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author TeamServer
 */
public class HttpBodyResponseTest {

    @Test
    public void testSameBody() throws IOException {
        HttpBodyResponse body = new HttpBodyResponse(new File("index.html"));
        String contenido = "<html><head>	<title>Index</title></head><body>	<h1>Pagina inicial :D</h1></body></html>";
        assertEquals(contenido, body.getContenido());
    }
    
    @Test
    public void testDistintBody() throws IOException {
        HttpBodyResponse body = new HttpBodyResponse(new File("lala.html"));
        String contenido = "<html><head>	<title>Index</title></head><body>	<h1>Pagina inicial :D</h1></body></html>";
        assertNotSame(contenido, body.getContenido());
    }
    
}
