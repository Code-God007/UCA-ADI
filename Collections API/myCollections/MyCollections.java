package myCollections;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCollections<T extends Comparable<T>> {
    List<T> data;
    Comparator<T> c;

    public void sort(List<T> data) {
        sort(data, null);
    }

    public void sort(List<T> data, Comparator<T> c) {
        this.data = data;
        this.c = c;
        qsort(0, data.size() - 1);
    }

    private int compareNow(T t1, T t2) {
        if (c == null) {
            return t1.compareTo(t2);
        } else {
            return c.compare(t1, t2);
        }
    }

    private void qsort(int L, int R) {
        if (R <= L)
            return;

        int p = L;
        for (int i = L + 1; i <= R; i++) {
            if (compareNow(data.get(i), data.get(L)) > 0) {
                swap(i, ++p);
            }
        }

        swap(L, p);
        qsort(L, p - 1);
        qsort(p + 1, R);
    }

    private void swap(int l, int p) {
        // T temp = data.get(l);
        // data.add(l, data.get(p));
        // data.add(p, temp);
        Collections.swap(data, l, p);
    }

}