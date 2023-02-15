package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Logger;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Logger ou = Logger.getLogger("com.api.jar");
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> wordFrequencyQueue = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry<String, Integer>::getValue).reversed());

        try {
            File file = new File(""+"C:\\Users\\Tringapps-user20\\Documents\\test.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next();
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                wordFrequencyQueue.offer(entry);
            }

            while (!wordFrequencyQueue.isEmpty()) {
                Map.Entry<String, Integer> entry = wordFrequencyQueue.poll();
                ou.info(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
