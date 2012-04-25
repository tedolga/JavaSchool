package five.io.file;

import java.io.*;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class FileReadingMain {

    public static void main(String[] args) throws IOException {
        File myFile = new File("my.txt");
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try {
            fileReader = new FileReader(myFile);
            bufferedReader = new BufferedReader(fileReader);
            char[] buffer = new char[100];
            int count;
            while ((count = bufferedReader.read(buffer)) != -1) {
                charArrayWriter.write(buffer, 0, count);
            }
        } finally {
            IOUtils.closeSafely(bufferedReader);
        }
        System.out.println(charArrayWriter.toCharArray());
    }
}
