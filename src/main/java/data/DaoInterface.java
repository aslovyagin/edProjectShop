package data;


import java.util.Set;

public interface DaoInterface<T,V> {


    T get(V id);

    Set<T> getAll();

    boolean insert(T item);

    boolean update(T item);

    boolean delete(V id);
}
