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

