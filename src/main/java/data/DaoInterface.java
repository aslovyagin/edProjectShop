package data;


import java.util.Set;

public interface DaoInterface<T> {


    T get(int id);

    Set<T> getAll();

    boolean insert(T item);

    boolean update(T item);

    boolean delete(int id);
}
