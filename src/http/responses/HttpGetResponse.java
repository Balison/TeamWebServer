/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http.responses;

import java.io.File;

/**
 *
 * @author Diego Gabriel
 */
public class HttpGetResponse extends HttpResponse{

    private final File contentFile;
    
    public HttpGetResponse(String protocol, File file, int status) {
        super(status, protocol);
        contentFile = file;
    }

    
    @Override
    public String render() {
        return super.render();
    }
    
    public boolean equals(HttpGetResponse other){
        return other.render().equals(render());
    }
    
}
