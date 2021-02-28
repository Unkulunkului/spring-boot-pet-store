package by.home.springbootpetstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long id;
    @NotNull
    @NotBlank
    private long petId;
    @NotNull
    @NotBlank
    private int quantity;
    private String shipDate;
    @NotNull
    @NotBlank
    private OrderStatusEnum status;
    @NotNull
    @NotBlank
    private boolean complete;
}
