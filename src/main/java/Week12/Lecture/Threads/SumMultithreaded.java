package Week12.Lecture.Threads;

import java.util.Arrays;
import java.util.Random;

public class SumMultithreaded {
    private static final int ARRAY_SIZE = 100_000_000;
    private static final int NUM_THREADS = 4;
    private static int [] array = new int [ARRAY_SIZE];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(100);
        }
        //Single-threaded sum calculation
        long startTime = System.currentTimeMillis();
        int singleThreadedSum = calculateSumSingleThreaded();
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded sum: " + singleThreadedSum);
        System.out.println("Single-threaded time: " + (endTime - startTime) + " ms");

        //Multithreaded sum calculation
        startTime = System.currentTimeMillis();
        int multithreadedSum = calculateMultiThreadedSum();
        endTime = System.currentTimeMillis();
        System.out.println("Multithreaded sum: " + multithreadedSum);
        System.out.println("Multithreaded time: " + (endTime - startTime) + " ms");
    }
    private static int calculateSumSingleThreaded() {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    private static int calculateMultiThreadedSum() {
        int [] partialSums = new int [NUM_THREADS];
        Thread [] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadIndex = i;
            threads[i] = new Thread( () -> {
                int partialSum = 0;
                for (int j = threadIndex; j < ARRAY_SIZE; j += NUM_THREADS) {
                    partialSum += array[j];
                }
                partialSums[threadIndex] = partialSum;
            });
            threads[i].start();
        }
        //Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Combine partial sums
        int sum = 0;
        for (int partialSum : partialSums) {
            sum += partialSum;
        }
        return sum;
    }
}