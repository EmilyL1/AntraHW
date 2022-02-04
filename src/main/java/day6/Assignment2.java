package day6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Assignment2 {
    public static void main(String[] args) {
        Criteria criteria = new Criteria("/Users/llm/Documents/Antra/assignments/AntraHW",true,".java");
        try {
            count(criteria);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void count(Criteria criteria) throws IOException {
        String filePath = criteria.getFilePath();
        Path path = Paths.get(filePath);

        if (Files.isDirectory(path)) {

            Map<String, Long> result = Files.list(path).filter(f -> f.toFile().isFile()).map(Assignment2::getExtension)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            System.out.println(result);
        } else {
            System.out.printf("Path was not found.");
        }

    }

    public static String getExtension(Path path) {
        String parts[] = path.toString().split("\\.");
        if (1 < parts.length) {
            return parts[parts.length - 1];
        }
        return path.toString();
    }
}
class Criteria{
    private String filePath;
    private boolean includeSubFolder;
    private String extension;

    public Criteria(String filePath, boolean includeSubFolder, String extension) {
        this.filePath = filePath;
        this.includeSubFolder = includeSubFolder;
        this.extension = extension;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isIncludeSubFolder() {
        return includeSubFolder;
    }

    public void setIncludeSubFolder(boolean includeSubFolder) {
        this.includeSubFolder = includeSubFolder;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
