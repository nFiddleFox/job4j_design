package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int i = findIndexById(id);
        Objects.checkIndex(i, mem.size());
        mem.set(i, model);
        return true;

    }

    @Override
    public boolean delete(String id) {
        int i = findIndexById(id);
        Objects.checkIndex(i, mem.size());
        mem.remove(i);
        return true;
    }

    @Override
    public T findById(String id) {
        int i = findIndexById(id);
        Objects.checkIndex(i, mem.size());
        return mem.get(i);
    }

    public int findIndexById(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
