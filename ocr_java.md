# Spire.OCR Image Stream Scanning
## Scan image stream using new OCR model
```java
// Create an instance of OcrScanner
OcrScanner scanner = new OcrScanner();

// Set up scanner configuration
ConfigureOptions configureOptions = new ConfigureOptions();

// Specify the language for text recognition, default is English (supported languages: English, Chinese, ChineseTraditional, French, German, Japanese, and Korean)
configureOptions.setLanguage("English");

// Specify the model path
configureOptions.setModelPath("F:\\win-x64");

// Apply the configuration to the scanner
scanner.ConfigureDependencies(configureOptions);

// Recognize text from the image stream
scanner.Scan(stream, OCRImageFormat.Gif);

// Get the recognized text
String scannedText = scanner.getText().toString();
```

---

# Spire OCR Image Scanning with Language Selection
## This code demonstrates how to use Spire OCR to scan an image with a specific language
```java
// Create an OcrScanner object
OcrScanner scanner = new OcrScanner();
// Set the dependent file path of the OcrScanner object
scanner.setDependencies(dependencies);
// Loads the specified language file
scanner.loadLanguageFile(languageFile);
// The OcrScanner object is used to scan the specified image file
scanner.scan(imageFile);
// Get the scanned text content
String scannedText = scanner.getText().toString();
```

---

# Spire.OCR Image Scanning
## Scan image and extract text using new OCR model
```java
// Create an instance of OcrScanner
OcrScanner scanner = new OcrScanner();

// Set up scanner configuration
ConfigureOptions configureOptions = new ConfigureOptions();

// Specify the language for text recognition, default is English (supported languages: English, Chinese, ChineseTraditional, French, German, Japanese, and Korean)
configureOptions.setLanguage("English");

// Specify the model path
configureOptions.setModelPath("F:\\win-x64");

// Apply the configuration to the scanner
scanner.ConfigureDependencies(configureOptions);

// Recognize text from the image
scanner.scan("Sample.png");

// Get the recognized text
String scannedText = scanner.getText().toString();
```

---

# Spire OCR for Java
## Scan local image and extract text using OCR
```java
// Create an OcrScanner object
OcrScanner scanner = new OcrScanner();
// Set the dependent file path
scanner.setDependencies("dependencies/");
// Scan the specified image file
scanner.scan("data/Sample.png");
// Get the scanned text content
String scannedText = scanner.getText().toString();
```

---

# OCR Text Coordinates Extraction
## Extract text and coordinates from image using OCR
```java
public class obtainTextCoordinates {
    public static void main(String[] args) throws Exception {
        // Create an instance of OcrScanner
        OcrScanner scanner = new OcrScanner();

        // Set up scanner configuration
        ConfigureOptions configureOptions = new ConfigureOptions();

        // Specify the language for text recognition, default is English
        configureOptions.setLanguage("English");

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
```

---

# OCR Scanning Rotated Image
## Extract text from rotated images using OCR
```java
// Create an instance of OcrScanner
OcrScanner scanner = new OcrScanner();

// Set up scanner configuration
ConfigureOptions configureOptions = new ConfigureOptions();

// Specify the language for text recognition, default is English
configureOptions.setLanguage("English");

// Set whether the image rotates or not
configureOptions.setAutoRotate(true);

// Specify the model path
configureOptions.setModelPath("win-x64");

// Apply the configuration to the scanner
scanner.ConfigureDependencies(configureOptions);

// Recognize text from the image
scanner.scan("data/RotatedImage.png");

// Get the recognized text
VisualTextAligner visualTextAligner = new VisualTextAligner(scanner.getText());
String scannedText = visualTextAligner.toString();
```

---

