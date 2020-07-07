package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int length = 0;
    private long modCount = 0;

    public SimpleArray(int size) {
        this.container = new Object[size];
    }

    public long getModCount() {
        return modCount;
    }

    public T get(int index) {
        Objects.checkIndex(index, length);
        return (T) container[index];
    }

    public void add(T model) {
        if (container.length == length - 1) {
            Object[] containerTemp = new Object[length * 2];
            System.arraycopy(container, 0, containerTemp, 0, length);
            container = containerTemp;
        }
        container[length] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private long expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return point < length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                   throw new NoSuchElementException();
                }
                return (T) container[point++];
            }
        };
    }
}
