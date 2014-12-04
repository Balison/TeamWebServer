
package webserver;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TeamServer
 */
public class FileManagerTest {
    
    @Test
    public void testFindFileEmptyName() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("/");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFileEmpty_fileNotExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("/arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_fileExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("/index.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_fileNotExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("/arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_noSlash_fileExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("index.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_noSlash_fileNotExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    
    @Test
    public void testTypeFileHtml() throws IOException {
        FileManager fileManager = new FileManager();
        String typeFileReturned = fileManager.getType(new File("index.html"));
        
        assertEquals("text/html", typeFileReturned);
    }
    
    @Test
    public void testTypeFileDefault() throws IOException {
        FileManager fileManager = new FileManager();
        String typeFileReturned = fileManager.getType(new File("index"));
        
        assertEquals("text/html", typeFileReturned);
    }
    
    @Test
    public void testUpdateFile400() throws IOException {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(400,null,null);
        String expected="<html><head><title>400 Bad Request</title></head>"
                        + "<body><h1>Bad Request</h1><p>Your browser sent a request that this server could not understand.<br/></p>"
                        + "</body></html>";
        String actual = fileManager.getContenido(fileReturned);
        assertEquals(expected,actual);
        
    }
   
    @Test
    public void testUpdateFile404() throws IOException {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(404,null,"/mundo.html");
        String expected = "<html><head><title>404 Not Found</title></head>"
                         + "<body><h1>Not Found</h1><p>The requested URL /mundo.html was not found on this server.<br/></p>"
                         + "</body></html>";
        String actual = fileManager.getContenido(fileReturned);
        assertEquals(expected, actual);
        
    }
    
    
    @Test
    public void testUpdateFile501() throws IOException {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(501,"GO","/index.html");
        String expected ="<html><head><title>501 Method Not Implemented</title></head>"
                       + "<body><h1>Method Not Implemented</h1>"
                       + "<p>GO to /index.html not supported.<br/></p>"
                       + "</body></html>"; 
        String actual = fileManager.getContenido(fileReturned);
        assertEquals(expected,actual);
        
    }
    /*
    @Test
    public void testLastModified() {
        FileManager fileManager = new FileManager();
        String dateReturned = fileManager.lastModified(new File("index.html"));
        String dateExpected = "Sat Nov 22 14:00:03 BOT 2014";
        assertEquals(dateExpected, dateReturned);
    }
    */
    @Test
    public void testContenido() throws IOException {
        FileManager fileManager = new FileManager();
        String contentReturned = fileManager.getContenido(new File("index.html"));
        String dateExpected = "<html><head><title>Index</title></head><body><h1>Pagina inicial :D</h1></body></html>";
        assertEquals(dateExpected, contentReturned);
    }
}
