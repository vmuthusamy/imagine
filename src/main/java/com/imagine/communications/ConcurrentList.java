package com.imagine.communications;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * Example of a thread safe {@Link ArrayList} using {@link ReentrantLock}
 * Created by venkatesh.muthusamy on 5/5/2016.
 */
public class ConcurrentList<T> {

    private final Lock lock = new ReentrantLock();

    private final List<T> list = new ArrayList<T>();

    private int size =0;

    public int getSize() {
        lock.lock();
        try {
            return size;
        }
        finally {
            lock.unlock();
        }
    }


    public void add(T element)
    {
        lock.lock();
        try{
            size++;
            list.add(element);
        } finally {
            lock.unlock();
        }
    }

    public void remove(T element)
    {
        lock.lock();
        try{
            size--;
            list.remove(element);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConcurrentList<?> that = (ConcurrentList<?>) o;

        return list != null ? list.equals(that.list) : that.list == null;

    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ConcurrentList{" +
                "list=" + list +
                '}';
    }
}
