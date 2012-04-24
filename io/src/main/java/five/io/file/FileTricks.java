package five.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class FileTricks {
    public static void main(String[] args) throws IOException {

        //Creating of File object.
        File file = new File("file.txt");
        if (!file.exists()) {
            //Physically  creation of file
            System.out.println("File was created: " + file.createNewFile());
        }
        //Deletion of file
        System.out.println("File was deleted: " + file.delete());
        //Recreation of file
        System.out.println("File was recreated: " + file.createNewFile());

        //Creation of File object which reference to the directory
        File dir = new File("src/main/java/five/io/file/");
        System.out.println("Files in " + dir.getAbsolutePath() + ":");

        //List of all files in directory
        String[] list = dir.list();
        for (String next : list) {
            System.out.println(next);
        }

        //List of all java files in directory
        list = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        System.out.println("Source files in " + dir.getAbsolutePath() + ":");
        for (String next : list) {
            System.out.println(next);
        }
    }
}
