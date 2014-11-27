
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
    public void testTypeFileHtml() {
        FileManager fileManager = new FileManager();
        String typeFileReturned = fileManager.getType(new File("index.html"));
        
        assertEquals("text/html", typeFileReturned);
    }
    
    @Test
    public void testTypeFileDefault() {
        FileManager fileManager = new FileManager();
        String typeFileReturned = fileManager.getType(new File("index"));
        
        assertEquals("text/plain", typeFileReturned);
    }
    
    @Test
    public void testUpdateFile400() {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(400);
        File fileExpected = new File("error400.html");
        assertEquals(fileExpected, fileReturned);
    }
    
    @Test
    public void testUpdateFile404() {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(404);
        File fileExpected = new File("error404.html");
        assertEquals(fileExpected, fileReturned);
    }
    
    
    @Test
    public void testUpdateFile501() {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(501);
        File fileExpected = new File("error501.html");
        assertEquals(fileExpected, fileReturned);
    }
    
    @Test
    public void testLastModified() {
        FileManager fileManager = new FileManager();
        String dateReturned = fileManager.lastModified(new File("index.html"));
        String dateExpected = "Sat Nov 22 14:00:03 BOT 2014";
        assertEquals(dateExpected, dateReturned);
    }
    
    @Test
    public void testContenido() throws IOException {
        FileManager fileManager = new FileManager();
        String contentReturned = fileManager.getContenido(new File("index.html"));
        String dateExpected = "<html><head>	<title>Index</title></head><body>"
                + "	<h1>Pagina inicial :D</h1></body></html>";
        assertEquals(dateExpected, contentReturned);
    }
}
