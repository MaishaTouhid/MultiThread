package ex4;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordCount {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java WordCount <file1> <file2> ...");
            return;
        }

        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(args.length);



        // Start a thread for each file
        for (String fileName : args) {
            executor.execute(new WordCountTask(fileName));
        }


        // Shutdown the executor after tasks are completed
        executor.shutdown();
    }

}

// Task to count words in a file
class WordCountTask implements Runnable {
    private final String fileName;

    public WordCountTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int wordCount = 0;
            String line;

            // Read each line and count words
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split by whitespace
            }

            System.out.println(fileName + ": " + wordCount);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }

}
