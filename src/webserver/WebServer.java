package webserver;

import http.responses.HttpResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeamServer
 */
public class WebServer {

    private final int PUERTO = 8000;
    private final RequestManager requestManager;

    public static final String SERVER_NAME = "apachito/0.1";

    public WebServer() {
        requestManager = new RequestManager();
    }
    
    public HttpResponse responseRequest(String request) throws IOException{
        return requestManager.management(request);
    }

    public void listeningPort(){
        BufferedReader entradaCliente;
        DataOutputStream salidaServer;
        String peticion = "";
        int tamano = 0;
        try (ServerSocket puertoServidor = new ServerSocket(PUERTO)) {
            Socket puerto = puertoServidor.accept();
            entradaCliente = new BufferedReader(new InputStreamReader(
                    puerto.getInputStream()));
            salidaServer = new DataOutputStream(puerto.getOutputStream());
            String linea = "";
            int indiceLinea = 0;

            while((linea = entradaCliente.readLine()) != null){
                if(linea.length() == 0){
                    break;
                }
                if(indiceLinea != 0){
                    peticion = peticion + "\n";
                }
                if(linea.startsWith("Content-Length: ")){
                    tamano = Integer.parseInt(linea.substring("Content-Length: ".length()));
                }
                indiceLinea++;
                peticion = peticion + linea; 
            }
            
            String parametros = leerParametros(tamano, entradaCliente);
            System.out.println(peticion);
            System.out.println(parametros);
            HttpResponse response = responseRequest(peticion);
            salidaServer.writeUTF(response.render());
            System.out.println(response.render());
            salidaServer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getMessage());
        }
        
    }

    private String leerParametros(int tamano, BufferedReader entrada) throws IOException {
        String parametros = "";
        for(int indiceCaracter = 0; indiceCaracter < tamano; indiceCaracter++){
            parametros = parametros + (char)entrada.read();
        }
        return parametros;
    }
}
