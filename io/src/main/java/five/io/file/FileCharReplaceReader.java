package five.io.file;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class FileCharReplaceReader extends FilterReader {

    private char oldChar;
    private char newChar;

    public FileCharReplaceReader(char oldChar, char newChar, Reader reader) {
        super(reader);
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    /**
     * Reads characters into a portion of an array.
     *
     * @throws java.io.IOException If an I/O error occurs
     */
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int result = in.read(cbuf, off, len);
        for (int i = off; i < len + off; i++) {
            if (cbuf[i] == oldChar) {
                cbuf[i] = newChar;
            }
        }
        return result;
    }

    /**
     * Reads characters into an array.  This method will block until some input
     * is available, an I/O error occurs, or the end of the stream is reached.
     *
     * @param cbuf Destination buffer
     * @return The number of characters read, or -1
     *         if the end of the stream
     *         has been reached
     * @throws java.io.IOException If an I/O error occurs
     */
    @Override
    public int read(char[] cbuf) throws IOException {
        int result = in.read(cbuf);
        for (int i = 0; i < cbuf.length; i++) {
            if (cbuf[i] == oldChar) {
                cbuf[i] = newChar;
            }
        }
        return result;
    }
}
