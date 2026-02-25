package com.adrar.cdafad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    @NotBlank(message = "Le title ne peut pas être vide")
    @Length(min = 2, max = 50)
    private String title;
    @Column(length = 255)
    @NotBlank(message = "La description ne peut pas être vide")
    @Length(min = 5, max = 255)
    private String description;
    @Column(name = "publish_at")
    @Past(message="La date doit être antérieure")
    private Date publishAt;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @ManyToMany
    @JoinTable(name = "game_category",
    joinColumns = @JoinColumn( name = "game_id" ),
    inverseJoinColumns = @JoinColumn( name = "category_id" ) )
    private ArrayList<Category> categories = new ArrayList<>();
}
