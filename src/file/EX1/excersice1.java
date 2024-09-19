package file.EX1;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class excersice1 {
    public static  boolean delete (String path) {
        File folder = new File(path);
        if (folder.isDirectory()) {
            for (File f: Objects.requireNonNull(folder.listFiles())) {
                if (f.isDirectory()) {
                    delete(f.getPath());
                }
                f.delete();
            }
            folder.delete();
            return !folder.exists();
        }

        return false;
    }
    public static boolean deleteChild (String path) {
        File folder = new File(path);

        if (folder.isDirectory()) {
            for (File f: folder.listFiles()) {
                if (f.isFile()) {
                    f.delete();
                }
                deleteChild(f.getPath());
            }
            return folder.listFiles().length != 0;
        }


        return true;
    }
    public static void main(String[] args) throws IOException {
        // CREATE FOLDER TREE !
        File folder1 =  new File("./src/file/EX3/child1");
        File folder2 =  new File("./src/file/EX3/child2");
        File file1 = new File("./src/file/EX3/child1/test1.java");
        File file2 = new File("./src/file/EX3/child1/test2.java");
        File file3 = new File("./src/file/EX3/child2/input.txt");
        File file4 = new File("./src/file/EX3/child2/output.txt");


        folder1.mkdirs();
        folder2.mkdirs();
        file1.createNewFile();
        file2.createNewFile();
        file3.createNewFile();
        file4.createNewFile();
//        DELETE FOLDER TREE !
        System.out.println(delete("./src/file/EX3"));
        System.out.println(deleteChild("./src/file/EX3"));

 }
}
