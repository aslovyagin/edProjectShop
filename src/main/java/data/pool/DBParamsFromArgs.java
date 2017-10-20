package data.pool;

class DBParamsFromArgs extends ADBParams {

    public DBParamsFromArgs(String... args) {
        driver = args[0];
        url = args[1];
        user = args[2];
        password = args[3];
        poolSize = parseNumberConnections(args[4]);
    }
}
