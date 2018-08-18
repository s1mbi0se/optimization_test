import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

public class TestCaseGenerator {

    private static final int LEVEL = 0;
    private static final Path TESTCASE_DIR = new File("testcases/level" + LEVEL).toPath();
    private static final int[] QUANTITY_LEVELS = new int[]{500, 1000, 2000, 5000};

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException {
        if (!TESTCASE_DIR.toFile().exists()) {
            TESTCASE_DIR.toFile().mkdirs();
        }

        final BufferedWriter writer = new BufferedWriter(new FileWriter(TESTCASE_DIR + "/input.txt", false));

        final File inputFile = TESTCASE_DIR.resolve("input.txt").toFile();
        final File expectedOutputFile = TESTCASE_DIR.resolve("expected.txt").toFile();

        final StringBuilder stringBuilder = new StringBuilder();
        int quantityLevel = QUANTITY_LEVELS[LEVEL];
        for (int i = 0; i < quantityLevel; i++) {
            for (int i1 = 0; i1 < 2; i1++) {
                final int quantityCase = 10 + RANDOM.nextInt(quantityLevel / 5);
                stringBuilder.setLength(0);
                for (int i2 = 0; i2 < quantityCase; i2++) {
                    final int value = RANDOM.nextInt(quantityLevel * 10);
                    stringBuilder.append(value).append(",");
                }
                stringBuilder.append("\n");
                writer.append(stringBuilder);
            }
        }

        writer.close();

        final IProcessor processor = new MyProcessor();
        processor.process(inputFile, expectedOutputFile);
    }

}
