package Week12.Lecture.Threads;

class CounterMultitreadedWithRunnable implements Runnable{
    private int numberThread;

    public CounterMultitreadedWithRunnable(int numberThread) {
        this.numberThread = numberThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from thread " + numberThread);
        }
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class CounterMuktithreadedWithRunnableMain {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            CounterMultitreadedWithRunnable counter = new CounterMultitreadedWithRunnable(i);
            Thread thread = new Thread(counter);
            thread.start();
        }
    }
}
