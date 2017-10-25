package service;

import data.daoImpl.ClientDao;
import data.daoImpl.UserDao;
import model.Client;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public static List<Client> getAllClients() {
        return new ArrayList<>(new ClientDao().getAll());
    }

    public static boolean checkClientExistence(String login) {
        return new UserDao().get(login) != null;
    }

    public static Client.Status getStatus(String login) {
        Client client = new ClientDao().get(login);
        return client != null
                ? client.getStatus()
                : Client.Status.BLOCKED;
    }

    public static void block(String login) {
        Client client = new ClientDao().get(login);
        client.setStatus(Client.Status.BLOCKED);
        new ClientDao().update(client);
    }
}
