package edu.hw3.Task8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {
    private int position;
    private final List<T> obj;

    public BackwardIterator(Collection<T> obj) {
        position = obj.size();
        this.obj = obj.stream().toList();
    }

    public boolean hasNext() {
        return position != 0;
    }

    public T next() {
        if (hasNext()) {
            return obj.get(--position);
        }
        throw new NoSuchElementException();
    }
}
