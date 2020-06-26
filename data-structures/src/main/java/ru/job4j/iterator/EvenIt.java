package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = point; i < data.length; i++) {
            if ((data[i] % 2) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int i = point; i < data.length; i++) {
            if ((data[i] % 2) == 0) {
                point = i + 1;
                return data[i];
            }
        }
        return null;
    }
}
