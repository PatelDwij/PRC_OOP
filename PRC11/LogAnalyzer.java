
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class LogAnalyzer {

    public static void main(String[] args) {
        Path folder = Paths.get("logs");

        try {
            // Create a folder for log files
            Files.createDirectories(folder);

            // Create sample log files
            Files.write(folder.resolve("app1.txt"),
                    Arrays.asList(
                        "Application started",
                        "ERROR: File not found",
                        "Application closed"
                    ));

            Files.write(folder.resolve("app2.txt"),
                    Arrays.asList(
                        "User logged in",
                        "ERROR: Connection failed",
                        "ERROR: Timeout occurred",
                        "User logged out"
                    ));

            Files.write(folder.resolve("app3.txt"),
                    Arrays.asList(
                        "Server started",
                        "Request completed"
                    ));

            int totalLines = 0;
            int keywordLines = 0;
            String keyword = "ERROR";

            // Read all text files in the folder
            try (DirectoryStream<Path> files =
                    Files.newDirectoryStream(folder, "*.txt")) {

                for (Path file : files) {
                    int fileLines = 0;
                    int fileMatches = 0;

                    try (BufferedReader reader =
                            Files.newBufferedReader(file)) {

                        String line;

                        while ((line = reader.readLine()) != null) {
                            fileLines++;

                            if (line.toLowerCase().contains(
                                    keyword.toLowerCase())) {
                                fileMatches++;
                            }
                        }
                    }

                    BasicFileAttributes attr =
                            Files.readAttributes(
                                file, BasicFileAttributes.class);

                    totalLines += fileLines;
                    keywordLines += fileMatches;

                    System.out.println("File: " + file.getFileName());
                    System.out.println("Size: "
                            + attr.size() + " bytes");
                    System.out.println("Lines: " + fileLines);
                    System.out.println("Keyword matches: "
                            + fileMatches);
                    System.out.println();
                }
            }

            System.out.println("Total lines: " + totalLines);
            System.out.println("Lines containing " + keyword
                    + ": " + keywordLines);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        System.out.println("25CE077 - Dwij");
    }
}
