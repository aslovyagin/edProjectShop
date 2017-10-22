package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Comparable<Product> {

    int id;
    String title;
    int price;
    String description;

    @Override
    public int compareTo(Product product) {
        Comparator<Product> cmp1 = Comparator.comparing(p -> p.title);
        Comparator<Product> cmp2 = Comparator.comparing(p -> p.id);
        Comparator<Product> cmp = cmp1.thenComparing(cmp2);

        return cmp.compare(this, product);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00\u20BD"); //₽
        return title + " : " + df.format(price);
    }
}
