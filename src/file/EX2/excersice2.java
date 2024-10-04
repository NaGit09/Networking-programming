package file.EX2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import static file.EX1.excersice1.delete;
public class excersice2 {
    public static void commandLine(File root) {
        if (!root.exists()) return;
        try (Scanner sc = new Scanner(System.in)) {
            boolean flag = true;
            while (flag) {
                System.out.print(root.getPath() + ">");
                String[] userInput = sc.nextLine().split(" ");
                String fileName =  userInput[userInput.length - 1];
                switch (userInput[0].toUpperCase()) {
                    case "EXIT" -> flag = false;
                    case "CD" -> {
                        cdFile(userInput[1],root , fileName);
                        flag = false;
                    }
                    case "DELETE" -> {
                        delete(root.getPath());
                        commandLine(new File(root.getParent()));
                        flag = false;
                    }
                    case "DIR" -> {
                       printListFile(root.listFiles());
                    }
                }
            }
        }

    }
    public static  void cdFile (String parttern , File file ,String nextFile ) {
        if (Objects.equals(parttern, "..")) {
            File parent = new File(file.getParent());
            commandLine(parent);
        }
        else commandLine(new File(file.getPath() + "\\" + nextFile ));
    }
    public static void printListFile (File [] listFile) {
        if (listFile != null) {
            for (File f : listFile) {
                if ((f.isDirectory())) System.out.println(f.getName().toUpperCase());
                else System.out.println(f.getName());
            }
        }
    }
    public static void printPattern(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("| ");
        }
    }
    public static void dirStart(File folder, int level) {
        if (!folder.exists()) return;
        if (folder.isDirectory()) {
            printPattern(level);
            System.out.println(folder.getName().toUpperCase());
            level++;
            File[] files = folder.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        String capacity = (Math.round((float) f.length() / 1024)) + " KB";
                        printPattern(level);
                        System.out.println("+-" + f.getName() + " Dung lượng : " + capacity);
                    } else dirStart(f, level);
                }
            }
        }
    }
    public static void findAll(File root, String... strings) {
        if (root == null || !root.exists()) return;
        if (!root.isDirectory() && handleName(root.getName(), strings)) {
            System.out.println(root.getPath());
            return;
        }
        if (root.listFiles() == null) return ;
        for (File f : Objects.requireNonNull(root.listFiles())) {
            findAll(f,strings);
        }
    }
    public static boolean handleName(String name, String[] ext) {
        int dotIndex = name.lastIndexOf('.');
        if (dotIndex == -1 && dotIndex == name.length()-1) return false;
        String fileExt = name.substring(dotIndex+1);
        for (String s : ext) {
            if(s.equalsIgnoreCase(fileExt)) return true;
        }
        return false;
    }
    public static void DeleteAll (File root , String ...strings) {
        if (root == null || !root.exists()) return ;
        if (root.isFile() && handleName(root.getName(), strings)) delete(root.getPath());
        File [] list = root.listFiles();
        if (list == null) return ;
        for (File f : list) {
            DeleteAll(f,strings);
        }
    }
    public static List<String> findAll(String path, String pattern) {
        List<String> result = new ArrayList<>();
        File directory = new File(path);

        // Tạo pattern từ chuỗi đầu vào (chuyển dấu * thành .* để sử dụng trong regex)
        String regex = pattern.replace("*", ".*");

        if (directory.exists() && directory.isDirectory()) {
//            searchFiles(directory, compiledPattern, result);
        }

        return result;
    }

    private static void searchFiles(File directory, String pattern, List<String> result) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                searchFiles(file, pattern, result);
            } else {
                if (pattern.matches(file.getName())) {
                    result.add(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
//        Arrays.stream(f.listFiles()).toList().forEach(System.out::println);
//        commandLine(new File(".\\src\\file"));
//        System.out.println(f.getTotalSpace());
//        dirStart(new File(".\\src\\file"), 0);
//        findAll(new File(".\\src"), "java", "txt");
    DeleteAll(new File(".\\src\\file\\EX3"),"java","txt");
    }
}