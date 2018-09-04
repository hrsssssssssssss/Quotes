package com.hrisko.quotes.repositories;

import com.hrisko.quotes.repositories.base.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<T> implements Repository<T> {

    private final List<T> mItems;

    public InMemoryRepository() {
        mItems = new ArrayList<>();
    }

    @Override
    public List<T> getAll() throws IOException {
        return mItems;
    }

    @Override
    public T add(T item) throws IOException {
        mItems.add(item);
        return item;
    }

    @Override
    public T edit(T item, int id) throws IOException {
        return null;
    }

    @Override
    public T getById(int id) throws IOException {
        return mItems.get(0);
    }
}
