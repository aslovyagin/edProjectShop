package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User> {
    int id;
    String lastName;
    String firstName;
    String login;
    String password;

    @Override
    public int compareTo(User User) {
        Comparator<User> cmp1 = Comparator.comparing(a -> a.lastName);
        Comparator<User> cmp2 = Comparator.comparing(a -> a.firstName);
        Comparator<User> cmp3 = Comparator.comparing(a -> a.id);
        Comparator<User> cmp = cmp1.thenComparing(cmp2).thenComparing(cmp3);

        return cmp.compare(this, User);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
