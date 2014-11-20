
package http.responses;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HttpResponseTest {

    @Test
    public void testEqualsResponse() {
        HttpResponse response1= new HttpResponse(new File("index.html"), 200);
        HttpResponse response2= new HttpResponse(new File("index.html"), 200);
        assertEquals(response1, response2);
    }
    
}
