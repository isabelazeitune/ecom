package br.com.rd.ecom.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ds_first_name")
    private String firstName;

    @NotNull
    @Column(name = "ds_last_name")
    private String lastName;

    @NotNull
    @Column(name = "nr_age")
    private Integer age;

}