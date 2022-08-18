package nio;

import java.nio.file.*;
import static java.nio.file.FileVisitResult.CONTINUE;

public class FileFinderExample {
    class Finder extends SimpleFileVisitor{
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");
        public FileVisitResult visitResult(Path path){
            if(matcher.matches(path.getFileName())){
                System.out.println("found "+path);
            }
            return CONTINUE;
        };
    }
    public void main(String[] args) {
        try {
            Finder finder = new Finder();
            Path path = Path.of("C:\\temp\\test.txt");
            FileVisitor<? super Path> Finder;
            Files.walkFileTree(Path.of("C:\\temp"),finder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
