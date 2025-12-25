import com.spire.ocr.*;

import java.awt.geom.Rectangle2D;
import java.io.FileWriter;
import java.io.IOException;

public class obtainTextCoordinates {
    public static void main(String[] args) throws Exception {

        // Create an instance of OcrScanner
        OcrScanner scanner = new OcrScanner();

        // Set up scanner configuration
        ConfigureOptions configureOptions = new ConfigureOptions();

        // Specify the language for text recognition, default is English (supported languages: English, Chinese, ChineseTraditional, French, German, Japanese, and Korean)
        configureOptions.setLanguage("English");

        //Please download the corresponding model dependencies based on your environment in the guide article(https://www.e-iceblue.com/Tutorials/Java/Spire.OCR-for-Java/Program-Guide/Extract-Text-from-Images-Using-the-New-Model-of-Spire.OCR-for-Java.html)
        // Specify the model path
        configureOptions.setModelPath("win-x64");

        // Apply the configuration to the scanner
        scanner.ConfigureDependencies(configureOptions);
        // Recognize text from the image
        scanner.scan("data/Sample.png");

        // Retrieve all text blocks detected by the OCR engine
        IOCRTextBlock[] blocks = scanner.getText().getBlocks();
        // Get the text coordinate
        String scannedText = PrintTextBlock(blocks, null);

        // Write the obtained text to a text file
        try (FileWriter writer = new FileWriter("obtainTextCoordinates.txt")) {
            writer.write(scannedText);
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    private static String PrintTextBlock(IOCRTextBlock[] blocks, StringBuilder sb) {
        // Create a new StringBuilder
        if (sb == null || sb.length() == 0) sb = new StringBuilder();

        // Skip processing if no blocks are provided
        if (blocks != null && blocks.length > 0) {
            for (IOCRTextBlock block : blocks) {
                // Retrieve the bounding rectangle of the current block
                Rectangle2D rectangle = block.getBox();

                // Format the rectangle coordinates and block details
                String t1 = String.format("Rectangle: [%f, %f, %f, %f] ,", rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
                String t2 = String.format("Level(%s): %s", block.getLevel(), block.getText());
                String Text = t1 + t2;
                Text = Text + "\n";

                // Append the formatted information to the result buffer
                sb.append(Text);

                // Recursively process any child text blocks
                PrintTextBlock(block.getTextBlock(), sb);

                // Add a newline after each line-level block for readability
                if (block.getLevel() == TextBlockType.Line) sb.append("\n");
            }
        }
        return sb.toString();
    }
}
