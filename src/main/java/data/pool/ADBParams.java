package data.pool;

import lombok.Data;

@Data
public abstract class ADBParams implements IDBParams {

    private static final int DEFAULT_POOL_SIZE = 10;

    protected String driver;
    protected String url;
    protected String user;
    protected String password;
    protected int poolSize;

    int parseNumberConnections(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            return DEFAULT_POOL_SIZE;
        }
    }
}
