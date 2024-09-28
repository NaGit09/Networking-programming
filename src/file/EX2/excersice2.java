package file.EX2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class excersice2 {
    public static void dirStart(String path, int level) {
        File folder = new File(path);
        if (!folder.exists()) {
            System.out.println("Đường dẫn không đúng !");
            return;
        }
        if (folder.isDirectory()) {
            for (int i = 0; i < level; i++) {
                System.out.print("| ");
            }
            System.out.println(folder.getName().toUpperCase() + " Dung lượng : " + (folder.length() / 1024));
            level++;
            for (File f : Objects.requireNonNull(folder.listFiles())) {
                if (f.isFile()) {
                    for (int i = 0; i < level; i++) {
                        System.out.print("| ");
                    }
                    System.out.println("+-" + f.getName() + " Dung lượng : " + (Math.round((float) f.length() / 1024)));
                }
                dirStart(f.getPath(), level);
            }
        }
    }

    public static void commandLine(String pathRoot) {
        File root = new File(pathRoot);
        if (!root.exists()) {
            System.out.println("file hoặc thư mục không tồn tại ");
            return;
        }
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print(pathRoot + ">");
            String[] userInput = sc.nextLine().split(" ");
            switch (userInput[0].toUpperCase()) {
                case "EXIT" -> flag = false;
                case "CD" -> {
                    if (Objects.equals(userInput[1], "..")) {
                        commandLine(root.getParent());
                    } else {
                        commandLine(root.getPath() + "\\" + userInput[userInput.length - 1]);
                    }

                    flag = false;
                }
                case "DELETE" -> {
                    root.delete();
                    commandLine(root.getParent());
                    flag = false;

                }
                case "DIR" -> {
                    for (File f : Objects.requireNonNull(root.listFiles())) {
                        if ((f.isDirectory())) {
                            System.out.println(f.getName().toUpperCase());
                        } else {
                            System.out.println(f.getName());
                        }

                    }
                }

            }
        }
    }

    public static void findAll(String path, String... strings) {
        File folder = new File(path);
        if (!folder.exists()) {
            System.out.println("Đường dẫn không đúng !");
            return;
        }
        if (folder.isDirectory()) {
            System.out.println(folder.getName());
            for (File f : Objects.requireNonNull(folder.listFiles())) {
                if (!f.isFile()) findAll(f.getPath(), strings);
                if (!handleName(f.getName(), strings)) continue;
                System.out.println(f.getName());
            }
        }
    }

    public static boolean handleName(String name, String[] ext) {
        String[] arr = name.split("\\.");
        for (String ex : ext) {
            if (arr[arr.length - 1].equalsIgnoreCase(ex)) {
                return true;
            }
        }
        return false;
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
//        commandLine(".\\src\\file");
//        System.out.println(f.getTotalSpace());
//        dirStart(".\\src\\file", 0);
        findAll(".\\src", "java", "txt");
    }
}