package by.home.springbootpetstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private long id;
    @NotEmpty
    @NotBlank
    private Category category;
    @Pattern(regexp = "[A-Z][a-z]{2,7}")
    private String name;
    private List<Tag>tags;
    @NotEmpty
    @NotBlank
    private PetStatusEnum status;

}
