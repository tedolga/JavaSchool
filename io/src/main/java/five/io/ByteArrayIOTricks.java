package five.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ByteArrayIOTricks {

    /**
     * Writes array of bytes to {@link ByteArrayOutputStream} and then retrieves resulting array
     *
     * @param sourceBytes array of bytes
     * @return resulting array of bytes
     * @throws IOException in case of input/output exceptions
     */
    public static byte[] rewriteBytes(byte[] sourceBytes) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(sourceBytes);
        return outputStream.toByteArray();
    }

    /**
     * Reads array of bytes from {@link ByteArrayInputStream} and then returns read array
     *
     * @param sourceBytes array of bytes
     * @return read arry of bytes
     * @throws IOException in case of input/output exceptions
     */
    public static byte[] readBytes(byte[] sourceBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sourceBytes);
        int length = sourceBytes.length;
        byte[] buffer = new byte[length];
        int i = 0;
        while (i < length) {
            i += inputStream.read(buffer, i, length - i);
        }
        return buffer;
    }
}
