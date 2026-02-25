package com.adrar.cdafad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;

@Entity
@Table
@Data
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "Le name ne peut pas être vide")
    @Length(min = 2, max = 50)
    private String name;
}
