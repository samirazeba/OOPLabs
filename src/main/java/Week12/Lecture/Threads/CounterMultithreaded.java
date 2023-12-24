package Week12.Lecture.Threads;

class CounterMultithreaded extends Thread{
    private int threadNumber;

    public CounterMultithreaded(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run () {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from thread " + this.threadNumber);

            try  {
                Thread.sleep(1000); // pauses the thread for specified number of miliseconds (1000 in this case)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class CounterMultithreadedMain {
    public static void main(String[] args) {
        /*CounterMultithreaded firstCounter = new CounterMultithreaded();
        CounterMultithreaded secondCounter = new CounterMultithreaded();
        firstCounter.start();
        secondCounter.start();*/

        //If we want to have 5 threads working in a same time
        for (int i = 0; i < 5; i++) {
            CounterMultithreaded counter = new CounterMultithreaded(3);
            counter.start();
        }
    }
}
