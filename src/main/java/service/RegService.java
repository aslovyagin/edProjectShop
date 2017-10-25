package service;

import data.daoImpl.ClientDao;
import data.daoImpl.UserDao;
import model.Client;
import model.User;

public class RegService {

    public static boolean addClient(String login, String lastName, String firstName, String password) {

        if (firstName == null || lastName == null || login == null || password == null)
            return false;

        if (new UserDao().get(login) != null)
            return false;

        Client client = new Client(login, lastName, firstName, Client.Status.ACTIVE);
        User user = new User(login, password);

        return new ClientDao().insert(client) && new UserDao().insert(user);
    }
}
