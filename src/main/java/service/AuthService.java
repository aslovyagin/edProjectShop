package service;

import data.ConnectionFactory;
import data.daoImpl.UserDao;
import model.User;



public class AuthService {
    public boolean checkPassword(String login, String password) {
        User user = new UserDao().get(login);
        if (password.equals("\"" + user.getPassword() + "\"")) {
            return true;
        } else {
            return false;
        }
    }
}
