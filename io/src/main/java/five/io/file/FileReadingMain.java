package five.io.file;

import java.io.*;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class FileReadingMain {

    public static void main(String[] args) {
        File myFile = new File("src/main/resources/my.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try {
            fileReader = new FileReader(myFile);
            bufferedReader = new BufferedReader(fileReader);
            char[] buffer = new char[100];
            int count;
            while ((count=bufferedReader.read(buffer)) != -1) {
                charArrayWriter.write(buffer, 0, count);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ioe) {
                 ioe.printStackTrace();
            }
        }
        System.out.println(charArrayWriter.toCharArray());

    }
}
