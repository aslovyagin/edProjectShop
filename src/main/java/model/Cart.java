package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private List<ClientProduct> clientProducts;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ClientProduct {
        private Product product;
        private int count;

        public double getSum() {
            return product.getPrice() * count;
        }
    }
}
