package by.home.springbootpetstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    private long id;
    @Pattern(regexp = "[A-Z][a-z]{2,7}")
    private String name;
}
