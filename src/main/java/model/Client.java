package model;

import util.StatusClient;

public class Client {

    private int id;
    private String firstName;
    private String surName;
    private StatusClient statusClient;
    private String adress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public StatusClient getStatus() {
        return statusClient;
    }

    public void setStatus(StatusClient statusClient) {
        this.statusClient = statusClient;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
