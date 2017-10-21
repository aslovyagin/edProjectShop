package data.pool;

import java.util.ResourceBundle;

public class DBParamsFromBundle extends ADBParams {

    public DBParamsFromBundle(ResourceBundle rb) {
        driver = rb.getString("driver");
        url = rb.getString("url");
        user = rb.getString("user");
        password = rb.getString("password");
        poolSize = parseNumberConnections(rb.getString("poolSize"));
    }

    public DBParamsFromBundle(String baseName) {
        this(ResourceBundle.getBundle(baseName));
    }
}
