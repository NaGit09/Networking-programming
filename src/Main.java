import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("./src/file/input.txt");
        System.out.println(f.getCanonicalFile());
        System.out.println(f.exists());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
    }
}