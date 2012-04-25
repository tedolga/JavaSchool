package five.io.file;

import java.io.*;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class CharReplacing {
    private static final char OLD_CHAR = 'H';
    private static final char NEW_CHAR = 'h';
    private static final String FILE_NAME = "src/main/resources/my.txt";

    public static void main(String[] args) throws IOException {
        char[] fileChars;
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(FILE_NAME);
            fileChars = CharReplacing.readConvertedChars(OLD_CHAR, NEW_CHAR, fileReader);
            fileWriter = new FileWriter(FILE_NAME);
            CharReplacing.writeToOutput(fileChars, fileWriter);
        } finally {
            IOUtils.closeSafely(fileReader);
            IOUtils.closeSafely(fileWriter);
        }
    }


    public static char[] readConvertedChars(char oldChar, char newChar, Reader reader) throws IOException {
        FileCharReplaceReader fileCharReplaceReader = null;
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try {
            fileCharReplaceReader = new FileCharReplaceReader(oldChar, newChar, reader);
            int count;
            char[] buffer = new char[100];
            while ((count = fileCharReplaceReader.read(buffer)) != -1) {
                charArrayWriter.write(buffer, 0, count);
            }
        } finally {
            IOUtils.closeSafely(fileCharReplaceReader);
        }
        return charArrayWriter.toCharArray();
    }

    public static void writeToOutput(char[] chars, Writer writer) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(writer);
            int off = 0;
            int length = chars.length;
            int portion = 100;
            while (off < length - 1) {
                if (portion > length - off) {
                    portion = length - off;
                }
                bufferedWriter.write(chars, off, portion);
                off += portion;
            }
            bufferedWriter.flush();
        } finally {
            IOUtils.closeSafely(bufferedWriter);
        }
    }

}
