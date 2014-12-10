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
        String peticion;
        try {
            ServerSocket puertoServidor = new ServerSocket(PUERTO);
            Socket puerto = puertoServidor.accept();
            entradaCliente = new BufferedReader(new InputStreamReader(
                    puerto.getInputStream()));
            salidaServer = new DataOutputStream(puerto.getOutputStream());
            peticion = entradaCliente.readLine();
            
            HttpResponse response = responseRequest(peticion);
            //falta que response se muestre
            salidaServer.writeUTF("recibido");
            puertoServidor.close();
            
        } catch (IOException ex) {
            Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
}
