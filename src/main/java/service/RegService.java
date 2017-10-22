package service;

import data.daoImpl.ClientDAO;
import data.daoImpl.UserDao;
import model.Client;
import model.User;
import util.StatusClient;

public class RegService {


    public static boolean addCleint(String firstName, String surName, String adress, String login, String password) {

        if (firstName == null || surName == null || adress == null || login == null || password == null) return false;
        if (new UserDao().get("\"" + login + "\"") != null) return false;

        Client client = new Client();
        client.setFirstName(firstName);
        client.setSurName(surName);
        client.setStatus(StatusClient.ACTIVE);
        client.setAdress(adress);

        User user = new User();
        int key = new ClientDAO().insert(client);
        if (key != -1) {
            user.setId(key);
            user.setLogin(login);
            user.setPassword(password);
        } else return false;


        if (new UserDao().insert(user) != -1)
            return true;
        else return false;
    }


}
