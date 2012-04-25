package five.io.file;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class IOUtils {

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ignored) {

            }
        }
    }

    public static ByteArrayOutputStream readFully(InputStream in) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n;
        while ((n = in.read(buffer)) > 0) {
            byteArrayOutputStream.write(buffer, 0, n);
        }
        return byteArrayOutputStream;
    }
}
