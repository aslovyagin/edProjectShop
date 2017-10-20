package data.pool;

public interface IDBParams {

    String getDriver();

    String getUrl();

    String getUser();

    String getPassword();

    int getPoolSize();
}
