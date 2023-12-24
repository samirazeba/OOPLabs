package Week12.Lecture.Threads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class FileMultithreaded {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        searchFileMultithreaded("7 rings");
        searchFile("7 rings");
    }
    public static List<String> readFile (String filename) {
        try {
            BufferedReader reader = new BufferedReader( new FileReader(filename));
            List<String> lines = reader.lines().collect(Collectors.toList());
            reader.close();
            return lines;
        } catch (Exception e) {
            System.out.println("Unable to read the file.");
        }
        return null;
    }
    public static void searchFileMultithreaded(String searchCriteria) {
        List<String> searchResult = new ArrayList<>();
        List<Thread> threadPool = new ArrayList<>();
        List<String> lines = readFile("C:\\Users\\PC\\Downloads\\songs.csv");

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadIndex = i;
            Thread thread = new Thread( () -> {
                for (int j = threadIndex; j < lines.size(); j += NUM_THREADS) {
                    if (lines.get(j).contains(searchCriteria))
                        searchResult.add(lines.get(j));
                }
            });
            thread.start();
            threadPool.add(thread);
        }

        for (Thread thread : threadPool) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("MULTITHREADES - Elapsed time: " + elapsedTime + " ms");
    }
    public static void searchFile(String searchCriteria) {
        List<String> searchResult = new ArrayList<>();
        List<String> lines = readFile("C:\\Users\\PC\\Downloads\\songs.csv");

        long startTIme = System.currentTimeMillis();

        for (String line : lines) {
            if (lines.contains(searchCriteria))
                searchResult.add(line);
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTIme;
        System.out.println("SINGLE-THREADED - Elapsed time: " + elapsedTime + " ms");
    }
}
