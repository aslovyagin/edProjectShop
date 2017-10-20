package data.pool;

import java.util.ResourceBundle;

public class DBParamsFromBundle extends ADBParams {

    /**
     * @param baseName the base name of the resource bundle,
     *                 a fully qualified class name
     */
    public DBParamsFromBundle(String baseName) {
        ResourceBundle rb = ResourceBundle.getBundle(baseName);
        driver = rb.getString("driver");
        url = rb.getString("url");
        user = rb.getString("user");
        password = rb.getString("password");
        poolSize = parseNumberConnections(rb.getString("poolSize"));
    }
}
