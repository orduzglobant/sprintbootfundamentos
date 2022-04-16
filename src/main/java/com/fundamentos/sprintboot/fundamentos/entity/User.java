package com.fundamentos.sprintboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user",nullable = false,unique = true)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    private LocalDate birtDate;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

}
