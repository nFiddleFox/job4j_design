package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        try {
            int i = findIndexById(id);
            mem.set(i, model);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            int i = findIndexById(id);
            mem.remove(i);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        try {
            int i = findIndexById(id);
            return mem.get(i);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public int findIndexById(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        throw new IllegalArgumentException("No element in the array found by " + id);
    }
}
