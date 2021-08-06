package team.healthtech.service.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AllergyDto {

    private Integer id;

    @NotBlank(message = "name.is-blank")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
