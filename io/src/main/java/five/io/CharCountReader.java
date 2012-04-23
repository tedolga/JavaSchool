package five.io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class CharCountReader extends Reader {

    private char mainChar;
    private CharArrayReader reader;
    private int charCount;

    public CharCountReader(char[] buffer, char mainChar) {
        this.mainChar = mainChar;
        reader = new CharArrayReader(buffer);
    }

    /**
     * Reads characters into a portion of an array.  This method will block
     * until some input is available, an I/O error occurs, or the end of the
     * stream is reached.
     *
     * @param cbuf Destination buffer
     * @param off  Offset at which to start storing characters
     * @param len  Maximum number of characters to read
     * @return The number of main chars read, or -1 if no main chars was read.
     * @throws java.io.IOException If an I/O error occurs
     */
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int result = reader.read(cbuf, off, len);
        for (int i = off; i < len + off; i++) {
            if (cbuf[i] == mainChar) {
                charCount++;
            }
        }
        return result;
    }

    /**
     * Closes the stream and releases any system resources associated with
     * it.  Once the stream has been closed, further read(), ready(),
     * mark(), reset(), or skip() invocations will throw an IOException.
     * Closing a previously closed stream has no effect.
     *
     * @throws java.io.IOException If an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        reader.close();
    }

    public int getCharCount() {
        return charCount;
    }
}
