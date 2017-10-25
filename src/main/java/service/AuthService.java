package service;

import data.daoImpl.UserDao;

public class AuthService {
    public boolean checkPassword(String login, String password) {
        return new UserDao().checkPassword(login, password);
    }
}
