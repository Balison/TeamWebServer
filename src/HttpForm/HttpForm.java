/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpForm;

import java.util.ArrayList;

/**
 *
 * @author franko
 */
public class HttpForm {
private final String resource;
private final String method;
private ArrayList<Control> controls;
public HttpForm(String action, String method) {
        resource=action;
        this.method=method.toUpperCase();
        controls=new ArrayList<>();
    }
public String getMethod(){
    return method;
}

}
