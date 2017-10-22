package service;

import data.daoImpl.ClientDAO;
import model.Client;
import util.StatusClient;

public class ClientService {

    public static boolean changeStatus(Client client, StatusClient statusClient) {
        ClientDAO clientDao = new ClientDAO();
        if (clientDao.get(client.getId()) != null && statusClient != null) {
            client.setStatus(statusClient);
            clientDao.insert(client);
            return true;

        }

        return false;
    }
}
