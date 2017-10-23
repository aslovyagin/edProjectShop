package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User> {

    String login;
    String password;

    @Override
    public int compareTo(User User) {
        Comparator<User> cmp = Comparator.comparing(u -> u.login);

        return cmp.compare(this, User);
    }

    @Override
    public String toString() {
        return login + " : " + password;
    }

}
