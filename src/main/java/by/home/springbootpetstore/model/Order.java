package by.home.springbootpetstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private long petId;
    private int quantity;
    private String shipDate;
    private OrderStatusEnum status;
    private boolean complete;
}
