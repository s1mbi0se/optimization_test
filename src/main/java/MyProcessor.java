import org.roaringbitmap.RoaringBitmap;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyProcessor implements IProcessor {

    @Override
    public void process(final File inputFile, final File outputFile) throws IOException {
        final List<String> lines = Files.readAllLines(inputFile.toPath());

        final Collection<RoaringBitmap> partialResults = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 2) {
            final RoaringBitmap roaringBitmap1 = createRoaringBitmap(lines.get(i));
            final RoaringBitmap roaringBitmap2 = createRoaringBitmap(lines.get(i + 1));

            final RoaringBitmap intersection = RoaringBitmap.and(roaringBitmap1, roaringBitmap2);
            partialResults.add(intersection);
        }

        final RoaringBitmap resultRoaringBitmap = new RoaringBitmap();
        for (RoaringBitmap partialResult : partialResults) {
            resultRoaringBitmap.or(partialResult);
        }

        String result = "";
        final int[] resultInts = resultRoaringBitmap.toArray();
        for (final int number : resultInts) {
            result += number + ",";
        }
        result += "\n";
        Files.write(outputFile.toPath(), result.getBytes());
    }

    private RoaringBitmap createRoaringBitmap(final String line) {
        final String[] numbersStr = line.split(",");
        final RoaringBitmap roaringBitmap = new RoaringBitmap();
        for (final String numberStr : numbersStr) {
            if (!numberStr.isEmpty()) {
                final int number = Integer.parseInt(numberStr);
                roaringBitmap.add(number);
            }
        }
        return roaringBitmap;
    }
}
