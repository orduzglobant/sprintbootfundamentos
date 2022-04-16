package com.fundamentos.sprintboot.fundamentos.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne
    private User user;



}
