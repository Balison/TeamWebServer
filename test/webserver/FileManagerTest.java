
package webserver;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Gabriel
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
}
