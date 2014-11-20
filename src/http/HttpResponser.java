package http;

import java.io.File;
import http.responses.*;

/**
 *
 * @author Diego Gabriel
 */
public class HttpResponser {

    public static HttpResponse respondTo(File file, int status) {
        HttpResponse response = new HttpResponse(file, status);
        return response;
    }

    public static HttpResponse respondTo(File file) {
        HttpResponse response = new HttpResponse(file);
        return response;
    }
}
