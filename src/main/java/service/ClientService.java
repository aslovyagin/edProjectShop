package service;

import data.daoImpl.ClientDao;
import model.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ClientService {

    public static List<Client> getAllClients() {

        return new ArrayList<>(new ClientDao().getAll());
    }
}
