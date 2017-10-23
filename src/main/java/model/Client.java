package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Comparator;

@Value
//@AllArgsConstructor
//@NoArgsConstructor
public class Client implements Comparable<Client> {

    String login;
    String lastName;
    String firstName;
    Status status;

    public enum Status {ADMIN, ACTIVE, BLOCKED}

    @Override
    public int compareTo(Client Client) {
        Comparator<Client> cmp = Comparator.comparing(a -> a.login);

        return cmp.compare(this, Client);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
