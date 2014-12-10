
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
        HttpBodyResponse body1 = new HttpBodyResponse(new File("index.html"));
        HttpBodyResponse body2 = new HttpBodyResponse(new File("index.html"));
        assertEquals(body1, body2);
    }
    
    @Test
    public void testDistintBody() throws IOException {
        HttpBodyResponse body1 = new HttpBodyResponse(new File("index.html"));
        HttpBodyResponse body2 = new HttpBodyResponse(new File("lala.html"));
        assertNotSame(body1, body2);
    }
    
    @Test 
    public void testRender() throws IOException{
        HttpBodyResponse body = new HttpBodyResponse(new File("index.html"));
        String renderCalculate = body.render();
        String renderExpected = "<html><head><title>Index</title></head><body>"
                + "<h1>Pagina inicial :D</h1></body></html>";
        assertEquals(renderExpected, renderCalculate);
    }
    
}
