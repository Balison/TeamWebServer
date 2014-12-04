package webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author TeamServer
 */
public class FileManager {

    private final String defaultFileName;

    public FileManager() {
        defaultFileName = "index.html";
    }

    public File findFile(String url) {
        File file;
        if (urlHasNoFile(url)) {
            url = url + defaultFileName;
        }

        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }

        file = new File(url);

        return file;
    }

    private boolean urlHasNoFile(String url) {
        return url.charAt(url.length() - 1) == '/';
    }

    public String getType(File file) throws IOException {
        String nombre = file.getName();
        if (nombre.contains(".html")) {
            return "text/html";
        }
        if (nombre.endsWith(".css")) {
            return "text/css";
        }
        if (nombre.endsWith(".txt")) {
            return "text/plain";
        }
        if (nombre.endsWith(".gif")) {
            return "image/gif";
        }
        if (nombre.endsWith(".png")) {
            return "image/png";
        }
        else{
            String contenido = getContenido(file);
            if(contenido.contains("html"))
                return "text/html";
        }
        return "text/plain";
    }

    public File updateFile(int status) {
        if (status == 501) {
            return new File("error501.html");
        }
        if (status == 400) {
            return new File("error400.html");
        } else {
            return new File("error404.html");
        }
    }

    public String getContenido(File file) throws IOException {
        String contenido = "";
        if (file.exists()) {
            FileReader readerFile = readerFile = new FileReader(file);
            BufferedReader buferFile = new BufferedReader(readerFile);
            String linea;
            if (file.length() > 0) {
                while ((linea = buferFile.readLine()) != null) {
                    contenido = contenido + linea;
                }
            }
            buferFile.close();
        }
        return contenido;
    }

    public String lastModified(File file) {
        Date fecha = new Date(file.lastModified());
        return fecha.toString();
    }
}
