package service;

import data.daoImpl.ClientDao;
import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public static List<Client> getAllClients() {
        return new ArrayList<>(new ClientDao().getAll());
    }
}
