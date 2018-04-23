import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int a = 0;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                    writeLock.lock();
                    list.add(i);

                        a++;
                    }finally {
                        writeLock.unlock();
                    }
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a < 100) {
                    try {
                        readLock.lock();
                        for (Integer aList : list) {
                            System.out.println(aList);
                            try {
                                Thread.sleep(0);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }finally {
                        readLock.unlock();
                    }
                }
            }
        }).start();
        myThread.start();
    }
}
