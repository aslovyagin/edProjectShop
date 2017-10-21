package service;

import data.daoImpl.ClientDAO;
import data.daoImpl.UserDao;
import model.Client;
import model.User;
import util.Status;

public class RegService {


    public static boolean addCleint(String firstName, String surName, String adress, String login, String password) {

        if (firstName == null || surName == null || adress == null || login == null || password == null) return false;
        if (new UserDao().get("\""+login+"\"") != null) return false;

        Client client = new Client();
        client.setFirstName(firstName);
        client.setSurName(surName);
        client.setStatus(Status.ACTIVE);
        client.setAdress(adress);

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        if (new UserDao().insert(user) && new ClientDAO().insert(client))
            return true;
        else return false;
    }


}
