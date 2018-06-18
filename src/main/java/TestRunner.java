import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Path;

public class TestRunner {

    /**
     * ATENÇÃO: Esta é a ÚNICA linha de código que pode ser modificada neste arquivo.
     */
    private static final int LEVEL = 0;
    private static final Path TESTCASE_DIR = new File("testcases/level" + LEVEL).toPath();

    private static Class<? extends IProcessor> PROCESSOR_CLASS = MyProcessor.class;

    public static void main(String[] args) throws Exception {
        final File inputFile = TESTCASE_DIR.resolve("input.txt").toFile();
        final File outputFile = TESTCASE_DIR.resolve("output.txt").toFile();
        final File expectedOutputFile = TESTCASE_DIR.resolve("expected.txt").toFile();

        for (int iteration = 0; iteration < 5; iteration++) {
            IProcessor processor = PROCESSOR_CLASS.newInstance();

            final long startTime = System.currentTimeMillis();
            processor.process(inputFile, outputFile);
            final long endTime = System.currentTimeMillis();

            if (!FileUtils.contentEquals(expectedOutputFile, outputFile)) {
                System.err.println("Saída errada! Arquivo: " + outputFile.getAbsolutePath());
                System.exit(1);
            }
            System.out.printf("Iteração %d levou %dms.%n", iteration, endTime - startTime);
        }
    }
}
