package org.example.concurrency.semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class ObjectPool<T,R> {
    final Semaphore semaphore;

    final List<T> pool;

    public ObjectPool(int size, T t) {
        pool = new Vector<T>();
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        this.semaphore = new Semaphore(size);
    }

    R exec(Function<T, R> function) {
        T t = null;

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t = pool.remove(0);
            return function.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }

    }



    public static void main(String[] args) {


        ObjectPool<Integer, String> pool = new ObjectPool<Integer, String>(10, 2);

        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });

    }
}
