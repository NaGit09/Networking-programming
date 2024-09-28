package file.EX1;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class excersice2 {

    public static void PrintDirTree(String path , int level) {
        File folder = new File(path);
        if (folder.isDirectory()) {
            for (int i =0 ; i < level ; i++) {
                System.out.print("| ");
            }
            System.out.println(folder.getName().toUpperCase());
            level++;

            for (File f: Objects.requireNonNull(folder.listFiles())) {
                if (f.isFile()) {
                    for (int i =0 ; i < level ; i++) {
                        System.out.print("| ");
                    }
                    System.out.println("+-"+f.getName());
                }

                PrintDirTree(f.getPath() , level);


            }


        }

    }

    public static void main(String[] args) throws IOException {
//        File folder1 =  new File("./src/file/EX3/child1");
//        File folder2 =  new File("./src/file/EX3/child2");
//
//        File file1 = new File("./src/file/EX3/child1/test1.java");
//        File file2 = new File("./src/file/EX3/child1/test2.java");
//        File file3 = new File("./src/file/EX3/child2/input.txt");
//        File file4 = new File("./src/file/EX3/child2/output.txt");
//
//
//        folder1.mkdirs();
//        folder2.mkdirs();
//        file1.createNewFile();
//        file2.createNewFile();
//        file3.createNewFile();
//        file4.createNewFile();
        PrintDirTree(".\\src\\file",0);
    }
}