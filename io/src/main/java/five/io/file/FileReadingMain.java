package five.io.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class FileReadingMain {

    public static void main(String[] args) {

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        char[] buffer;
        try {
            fileReader = new FileReader("my.txt");
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ignored) {

            }
        }

    }
}
