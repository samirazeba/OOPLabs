package Week12.Lecture.Threads;

class CounterSync {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
class SynchronizationExample {
    public static void main(String[] args) {
        CounterSync counter = new CounterSync();

        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread( () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count: " + counter.getCount());
    }
}
