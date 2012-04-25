package five.io.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class FileCharReplaceReaderTest {
    @Test
    public void testRead() {
        FileCharReplaceReader fileCharReplaceReader = null;
        char[] fromFile = new char[15];
        try {
            fileCharReplaceReader = new FileCharReplaceReader('a', 'A', new FileReader("src/test/resources/test.txt"));
            Assert.assertEquals(13, fileCharReplaceReader.read(fromFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileCharReplaceReader != null) {
                try {
                    fileCharReplaceReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Assert.assertEquals("AbrA-cAdAbrA!", new String(fromFile).substring(0, 13));

    }


}
