package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private int length = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    public void add(T model) {
        if (length < data.length) {
            data[length++] = model;
        }
    }

    public void set(int index, T model) {
        data[Objects.checkIndex(index, length)] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, length);
        if (index == (length - 1)) {
            length--;
        } else {
            for (int i = index; i < length; i++) {
                data[i] = data[i + 1];
            }
            length--;
        }

    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[Objects.checkIndex(index, length)];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleListIterator();
    }

    private class SimpleListIterator implements Iterator<T> {
        private int cursor;

        SimpleListIterator() {

        }

        @Override
        public boolean hasNext() {
            return cursor != length;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (T) data[cursor++];
        }
    }
}
