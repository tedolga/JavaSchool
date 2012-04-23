package five.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ByteArrayIOTricks {

    public static byte[] rewriteBytes(byte[] sourceBytes) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(sourceBytes);
        return outputStream.toByteArray();
    }

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
