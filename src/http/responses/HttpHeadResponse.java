/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package http.responses;


/**
 *
 * @author Diego Gabriel
 */
public class HttpHeadResponse extends HttpResponse{

    
    public HttpHeadResponse(String protocol, int status) {
        super(status, protocol);
    }
    
    @Override
    public String render() {
        return super.render();
    }
    
    public boolean equals(HttpHeadResponse other){
        return other.render().equals(render());
    }
    
}
