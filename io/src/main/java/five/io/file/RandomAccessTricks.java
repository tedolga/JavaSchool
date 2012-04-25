package five.io.file;

import java.io.*;
import java.util.Scanner;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class RandomAccessTricks {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("src/main/resources/");
        archiveFiles(dir, "Random");
        executeFromArchive("Random");
    }

    public static void archiveFiles(File dir, String name) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = null;
        try {
            File[] list = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });
            randomAccessFile = new RandomAccessFile(dir + "/" + name, "rw");
            try {
                for (File next : list) {
                    sendToArchive(next, randomAccessFile);
                }
            } catch (NullPointerException npe) {
                System.out.println("There are no .txt files in " + dir.getAbsolutePath()
                );
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            closeSafely(randomAccessFile);
        }
    }

    public static void sendToArchive(File next, RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.writeUTF(next.getName() + "0");
        randomAccessFile.writeLong(next.length());
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(next);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                randomAccessFile.writeBytes(scanner.nextLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            closeSafely(fileInputStream);
        }
        next.delete();

    }

    public static void executeFromArchive(String archiveName) throws FileNotFoundException {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(archiveName, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.readUTF();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
