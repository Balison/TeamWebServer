/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpForm;

/**
 *
 * @author franko
 */
public class Texto implements Control {

    
    String name;
    String valueInit;
    String value;

    public Texto(String name, String valueInicial, String valuerActual) {
            
            this.name=name;
            this.valueInit=valueInicial;
            value=valuerActual;
    }

    @Override
    public String getValue(String name) {
       String respuesta=null;
       if(this.name.equals(name)){
        respuesta= value;
       }
       return respuesta;
    }

}
