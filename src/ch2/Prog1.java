package ch2;

import java.util.concurrent.*;

public class Prog1 {

    public static void main(String[] args) {

        Callable<String> stringCallable = () -> Thread.currentThread().getName();


        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> sampleThread = executorService.submit(new myRunnable("Sample Thread"));

        System.out.println("name: " + sampleThread);

    }
}

class myRunnable implements Runnable {

    private final String name;

    myRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name);
    }
}

