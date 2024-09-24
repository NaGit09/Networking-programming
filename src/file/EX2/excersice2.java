package file.EX2;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class excersice2 {
    public static void commandLine (String pathRoot) {
        File root = new File(pathRoot);

        if (!root.exists()) {
            System.out.println("file hoặc thư mục không tồn tại ");
            return ;
        }

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print(pathRoot+">");
            String [] userInput = sc.nextLine().split(" ");

            switch (userInput[0].toUpperCase()) {
                case "EXIT" -> flag = false;
                case "CD" -> {
                    if (Objects.equals(userInput[1], "..")) {
                        commandLine(root.getParent());
                    } else {
                        commandLine(root.getPath() + "\\" + userInput[userInput.length - 1]);
                    }
                    flag=false;

                }
                case "DELETE" -> {
                    root.delete();
                    commandLine(root.getParent());
                    flag=false;

                }
                case "DIR" -> {
                    for (File f: Objects.requireNonNull(root.listFiles())) {
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
    public static void main(String[] args) {
        File f = new File("");
        System.out.println(f.exists());
//        Arrays.stream(f.listFiles()).toList().forEach(System.out::println);
        commandLine(".\\src\\file");
    }
}