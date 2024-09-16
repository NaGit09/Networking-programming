import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("./src/file");

        System.out.println(f.getCanonicalFile());
        System.out.println(f.exists());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.length());
        System.out.println(Arrays.toString(f.listFiles()));
        System.out.println(f.mkdir());
        System.out.println(f.canRead());
        System.out.println(f.createNewFile());
    }
}