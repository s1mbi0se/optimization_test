import java.io.File;
import java.io.IOException;

public interface IProcessor {
    void process(final File inputFile, final File outputFile) throws IOException;
}
