package five.io.file;

import java.io.*;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class RandomAccessTricks {
    public static void main(String[] args) throws IOException {
        File dir = new File("src/main/resources/");
        archiveFiles(dir, "Random");
        executeFromArchive(dir, "Random");
    }

    public static void archiveFiles(File dir, String name) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            File[] list = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });
            randomAccessFile = new RandomAccessFile(dir + File.separator + name, "rw");
            for (File next : list) {
                sendToArchive(next, randomAccessFile);
            }
        } finally {
            IOUtils.closeSafely(randomAccessFile);
        }

    }

    public static void sendToArchive(File next, RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.write(next.getName().getBytes());
        randomAccessFile.write((byte) 0);
        randomAccessFile.writeLong(next.length());
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(next);
            byte[] buffer = new byte[100];
            int count;
            while ((count = fileInputStream.read(buffer)) != -1) {
                randomAccessFile.write(buffer, 0, count);
            }
        } finally {
            IOUtils.closeSafely(fileInputStream);
        }
        if (!next.delete()) {
            throw new IOException("Can't delete file " + next.getAbsolutePath());
        }
    }

    public static void executeFromArchive(File dir, String archiveName) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(dir.getAbsolutePath() + File.separator + archiveName, "rw");
        randomAccessFile.seek(0);
        while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte current;
            while ((current = randomAccessFile.readByte()) != 0) {
                byteArrayOutputStream.write(current);
            }
            String name = new String(byteArrayOutputStream.toByteArray());
            File file = new File(dir.getAbsolutePath() + File.separator + name);
            long fileLength = randomAccessFile.readLong();
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                int count;
                int totalCount = 0;
                byte[] buffer = new byte[100];
                while (totalCount < fileLength) {
                    long remain = fileLength - totalCount;
                    if (remain < 100) {
                        count = randomAccessFile.read(buffer, 0, (int) remain);
                    } else {
                        count = randomAccessFile.read(buffer);
                    }
                    fileOutputStream.write(buffer, 0, count);
                    totalCount += count;
                }
            } finally {
                IOUtils.closeSafely(fileOutputStream);
            }
        }
    }

}
