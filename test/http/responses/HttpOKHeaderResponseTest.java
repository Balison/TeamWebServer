
package http.responses;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HttpOKHeaderResponseTest {


    @Test
    public void testEqualsHeader() {
        HttpOKHeaderResponse header1 = new HttpOKHeaderResponse();
        HttpOKHeaderResponse header2 = new HttpOKHeaderResponse();
        assertEquals(header1, header2);
    }
    
}
