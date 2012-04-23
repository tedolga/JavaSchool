package five.io;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class CharCountWriter extends Writer {

    private char mainChar;
    private CharArrayWriter writer;
    private int charCount;


    public CharCountWriter(char mainChar) {
        this.mainChar = mainChar;
        writer = new CharArrayWriter();
    }

    /**
     * Writes a portion of an array of characters.
     *
     * @param cbuf Array of characters
     * @param off  Offset from which to start writing characters
     * @param len  Number of characters to write
     * @throws java.io.IOException If an I/O error occurs
     */
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        writer.write(cbuf, off, len);
        for (int i = off; i < len + off; i++) {
            if (cbuf[i] == mainChar) {
                charCount++;
            }
        }
    }

    /**
     * Flushes the stream.  If the stream has saved any characters from the
     * various write() methods in a buffer, write them immediately to their
     * intended destination.  Then, if that destination is another character or
     * byte stream, flush it.  Thus one flush() invocation will flush all the
     * buffers in a chain of Writers and OutputStreams.
     * <p/>
     * <p> If the intended destination of this stream is an abstraction provided
     * by the underlying operating system, for example a file, then flushing the
     * stream guarantees only that bytes previously written to the stream are
     * passed to the operating system for writing; it does not guarantee that
     * they are actually written to a physical device such as a disk drive.
     *
     * @throws java.io.IOException If an I/O error occurs
     */
    @Override
    public void flush() throws IOException {
        writer.flush();
    }

    /**
     * Closes the stream, flushing it first. Once the stream has been closed,
     * further write() or flush() invocations will cause an IOException to be
     * thrown. Closing a previously closed stream has no effect.
     *
     * @throws java.io.IOException If an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        writer.flush();
    }

    public int getCharCount() {
        return charCount;
    }
}
