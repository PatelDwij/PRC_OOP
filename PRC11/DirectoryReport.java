
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class DirectoryReport {

    public static void main(String[] args) {
        Path root = Paths.get("sample-folder");
        Path report = Paths.get("folder-report.txt");

        try {
            // Create sample folders and files
            Files.createDirectories(root.resolve("docs"));
            Files.createDirectories(root.resolve("images"));

            Files.write(root.resolve("readme.txt"),
                    Arrays.asList("Welcome to Java NIO"));

            Files.write(root.resolve("docs/notes.txt"),
                    Arrays.asList("Java file handling"));

            Files.write(root.resolve("images/photo.txt"),
                    Arrays.asList("Sample image information"));

            List<String> lines = new ArrayList<>();
            int[] count = {0};
            long[] totalSize = {0};

            lines.add("DIRECTORY TREE REPORT");
            lines.add("=====================");

            // Walk through all folders and files
            Files.walkFileTree(root,
                    new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(
                        Path file, BasicFileAttributes attr) {

                    String name = root.relativize(file).toString();

                    String info = "Name: " + name
                            + " | Size: " + attr.size()
                            + " bytes | Modified: "
                            + attr.lastModifiedTime();

                    lines.add(info);

                    count[0]++;
                    totalSize[0] += attr.size();

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(
                        Path file, IOException exc) {

                    lines.add("Could not read: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });

            lines.add("");
            lines.add("Total files: " + count[0]);
            lines.add("Total size: " + totalSize[0] + " bytes");

            // Save report outside the scanned folder
            Files.write(report, lines);

            System.out.println("Report created: "
                    + report.toAbsolutePath());
            System.out.println("Total files: " + count[0]);
            System.out.println("Total size: "
                    + totalSize[0] + " bytes");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("25CE077 - Dwij");
    }
}
