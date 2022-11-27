package example1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                // Code that will run in a new thread - 1
//                System.out.println("We are now in thread " + Thread.currentThread().getName());
//                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
//                // 1
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("Misbehaving thread"); // 2

        // 2
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happen in thread " + t.getName()
                                    + " the error is " + e.getMessage());
            }
        });

        thread.start();

//        // 1
//        thread.setName("New Worker Thread");
//        thread.setPriority(Thread.MAX_PRIORITY);
//
//        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
//        thread.start();
//        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
//        // 1
    }
}
