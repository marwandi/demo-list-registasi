package entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class PesertaEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 150)
    private String nama;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private String email;

    @Column
    @NotNull
    @NotEmpty
    private String noHp;


}
