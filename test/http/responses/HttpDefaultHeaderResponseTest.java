/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http.responses;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HttpDefaultHeaderResponseTest {

    @Test
    public void testEqualsHeader() {
        HttpDefaultHeaderResponse header1 = new HttpDefaultHeaderResponse();
        HttpDefaultHeaderResponse header2 = new HttpDefaultHeaderResponse();
        assertEquals(header1, header2);
    }
}
