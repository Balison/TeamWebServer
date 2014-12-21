
package webserver;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TeamWebServer
 */
public class ParametersManager {
    
    public Map<String, String> load(String parametros) {
        Map<String, String> tuplas = new HashMap<>();
        String[] atributoValor = parametros.split("&");
        String[] pareja;
        for(String tupla: atributoValor){
            pareja = tupla.split("=");
            tuplas.put(pareja[0], pareja[1].replace("+", " "));
        }
        return tuplas;
   }
}
