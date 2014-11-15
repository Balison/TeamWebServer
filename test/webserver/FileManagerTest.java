/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webserver;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Gabriel
 */
public class FileManagerTest {
    
    public FileManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findFile method, of class FileManager.
     */
    @Test
    public void testFindFileEmptyName() {
        FileManager fileManager = new FileManager("index.html");
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("/");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFileEmpty_fileNotExists() {
        FileManager fileManager = new FileManager("arqui.html");
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("/");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_fileExists() {
        FileManager fileManager = new FileManager("index.html");
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("/index.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_fileNotExists() {
        FileManager fileManager = new FileManager("index.html");
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("/arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_noSlash_fileExists() {
        FileManager fileManager = new FileManager("index.html");
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("index.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_noSlash_fileNotExists() {
        FileManager fileManager = new FileManager("index.html");
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
}
