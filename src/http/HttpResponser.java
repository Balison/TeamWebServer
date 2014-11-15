package http;

import java.io.File;
import http.responses.*;

/**
 *
 * @author Diego Gabriel
 */
public class HttpResponser {

    public static HttpResponse respondTo(String vProtocol,
            File file, int status) {
        HttpResponse response = new HttpResponse(vProtocol, file, status);
        return response;
    }

    public static HttpResponse respondTo(String vProtocol, int status) {
        HttpResponse response = new HttpResponse(vProtocol, status);
        return response;
    }

}
