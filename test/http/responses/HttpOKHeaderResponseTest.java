
package http.responses;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HttpOKHeaderResponseTest {


    @Test
    public void testEqualsHeader() {
        HttpOKHeaderResponse header1 = new HttpOKHeaderResponse(new File("/index.html"));
        HttpOKHeaderResponse header2 = new HttpOKHeaderResponse(new File("/index.html"));
        assertEquals(header1, header2);
    }
    
    @Test
    public void testNotSameHeader() {
        HttpOKHeaderResponse header1 = new HttpOKHeaderResponse(new File("/index.html"));
        HttpOKHeaderResponse header2 = new HttpOKHeaderResponse(new File("/lala.html"));
        assertNotSame(header1, header2);
    }
    
}
