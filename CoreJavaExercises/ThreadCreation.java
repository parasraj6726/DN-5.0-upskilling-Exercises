// Q26: Thread Creation
public class ThreadCreation {

    static class MyThread extends Thread {
        private String threadName;

        MyThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " - Message " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    static class MyRunnable implements Runnable {
        private String taskName;

        MyRunnable(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(taskName + " - Message " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread-1");
        Thread t2 = new Thread(new MyRunnable("Thread-2"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Both threads finished.");
    }
}
